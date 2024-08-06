@echo off
REM Check if virtual environment directory exists
IF NOT EXIST venv (
    REM Create virtual environment
    python -m venv venv
)

REM Activate virtual environment
call .\venv\Scripts\activate

REM Install required packages
pip install -r requirements.txt

REM Run the Python application
python app.py

@echo on
