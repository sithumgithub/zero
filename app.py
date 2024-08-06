import os
import google.generativeai as genai
from dotenv import load_dotenv

# Load the .env file
load_dotenv()

# Retrieve the API key from environment variables
GOOGLE_API_KEY = os.getenv('GOOGLE_API_KEY')
if GOOGLE_API_KEY is None:
    print("Error: GOOGLE_API_KEY is not set in the .env file.")
    input("Press Enter to exit...")
    exit(1)

# Configure the generative AI model
try:
    genai.configure(api_key=GOOGLE_API_KEY)
    model = genai.GenerativeModel('gemini-pro')
except Exception as e:
    print(f"Error initializing Generative AI model: {e}")
    input("Press Enter to exit...")
    exit(1)

# Main interaction loop
while True:
    user_input = input("How can I assist you? (type 'exit' to close) ")
    if user_input.lower() == 'exit':
        print("Goodbye!")
        break
    try:
        response = model.generate_content(user_input)
        print(response.text)
    except Exception as e:
        print(f"Error generating response: {e}")

# Ensure the script waits for user input before exiting
input("Press Enter to exit...")
