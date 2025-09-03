import joblib
import pandas as pd

model_lung = joblib.load("models/lung_cancer.pkl")
model_cervix = joblib.load("models/cervix_cancer.pkl")

def predict_lung(df: pd.DataFrame):
    proba = model_lung.predict_proba(df)[0]
    pred = model_lung.predict(df)[0]
    return {"lung_cancer_risk": "YES" if pred==1 else "NO",
            "probability_yes": float(proba[1]),
            "probability_no": float(proba[0])}

def predict_cervix(df: pd.DataFrame):
    proba = model_cervix.predict_proba(df)[0]
    pred = model_cervix.predict(df)[0]
    return {"cervix_cancer_risk": "YES" if pred==1 else "NO",
            "probability_yes": float(proba[1]),
            "probability_no": float(proba[0])}
