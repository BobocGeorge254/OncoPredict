from fastapi import FastAPI, HTTPException, Depends
import pandas as pd

from app.models import *
from app.auth import users_db, get_password_hash, verify_password, create_access_token, get_current_user
from app.ml import predict_lung, predict_cervix

app = FastAPI()

@app.post("/register")
def register(user: UserRegister):
    if user.username in users_db:
        raise HTTPException(status_code=400, detail="Username exists")
    users_db[user.username] = {"hashed_password": get_password_hash(user.password)}
    return {"msg": "User registered successfully"}

@app.post("/login")
def login(user: UserLogin):
    db_user = users_db.get(user.username)
    if not db_user or not verify_password(user.password, db_user["hashed_password"]):
        raise HTTPException(status_code=401, detail="Incorrect username or password")
    token = create_access_token({"sub": user.username})
    return {"access_token": token, "token_type": "bearer"}


@app.post("/predict-lung")
def lung_endpoint(data: LungPatientData, current_user: str = Depends(get_current_user)):
    df = pd.DataFrame([data.model_dump()])
    return predict_lung(df)

@app.post("/predict-cervix")
def cervix_endpoint(data: CervicalPatientData, current_user: str = Depends(get_current_user)):
    df = pd.DataFrame([data.model_dump()])
    return predict_cervix(df)

@app.get("/debug/users")
def get_users():
    return users_db