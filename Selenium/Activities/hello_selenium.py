# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service = service) as driver:
  
  # Open the browser to the URL
  driver.get("https://training-support.net")
  
  # Perform testing and assertions
  ...
  
  # Close the browser
  # Feel free to comment out the line below
  # so it doesn't close too quickly
  driver.quit()