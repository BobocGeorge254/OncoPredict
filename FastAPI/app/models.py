from pydantic import BaseModel

class UserRegister(BaseModel):
    username: str
    password: str

class UserLogin(BaseModel):
    username: str
    password: str

class Token(BaseModel):
    access_token: str
    token_type: str

class LungPatientData(BaseModel):
    GENDER: int
    AGE: int
    SMOKING: int
    YELLOW_FINGERS: int
    CHRONIC_DISEASE: int
    FATIGUE: int
    WHEEZING: int
    ALCOHOL_CONSUMING: int
    COUGHING: int
    SHORTNESS_OF_BREATH: int
    SWALLOWING_DIFFICULTY: int
    CHEST_PAIN: int

class CervicalPatientData(BaseModel):
    AGE: int
    NUMBER_OF_SEXUAL_PARTNERS: int
    FIRST_SEXUAL_INTERCOURSE: int
    NUM_OF_PREGNANCIES: int
    SMOKES: int
    SMOKES_YEARS: int
    SMOKES_PACKS_YEAR: int
    HORMONAL_CONTRACEPTIVES: int
    HORMONAL_CONTRACEPTIVES_YEARS: int
    IUD: int
    IUD_YEARS: int
    STDS: int
    STDS_NUMBER: int
    STDS_HPV: int
