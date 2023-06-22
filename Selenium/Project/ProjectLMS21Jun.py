import time
from typing import Self
import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains 
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select
# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

username = "root"
password = "pa$$w0rd"
# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Initialize the wait object
    wait = WebDriverWait(driver, 10)

    # Navigate to the URL
    driver.get("https://alchemy.hguy.co/lms")
    # Print the title of the page
    pagetitle = driver.title
    assert driver.title == "Alchemy LMS – An LMS Application"
    print("Page title is: ", pagetitle)

    heading = driver.find_element(By.XPATH, "//h1[@class='uagb-ifb-title']").text
    print("Page heading is: ", heading)
    assert heading == "Learn from Industry Experts"

    titlefirstbox = driver.find_element(By.XPATH, "//h3[@class='uagb-ifb-title']").text
    print("Title of first info box is: ", titlefirstbox)
    assert titlefirstbox == "Actionable Training"

    titlesecondcourse = driver.find_element(By.XPATH, "//h3[text()='Email Marketing Strategies']").text
    print("Title of second most popular course is: ", titlesecondcourse)
    assert titlesecondcourse == "Email Marketing Strategies"

    driver.find_element(By.XPATH, "//a[text()='My Account']").click()
    myaccountpagetitle = driver.title
    assert myaccountpagetitle == "My Account – Alchemy LMS"
    print("You are now on My Account page and title of the page is:" + myaccountpagetitle)

    driver.find_element(By.XPATH, "//*[contains(@class,'ld-login ld-login ld-login-text ld-login-button ld-button')]").click()
    driver.find_element(By.ID,'user_login').send_keys(username)
    driver.find_element(By.ID,'user_pass').send_keys(password)
    driver.find_element(By.ID,'wp-submit').click()

    
    user = driver.find_element(By.XPATH,"//*[contains(@class,'display-name')]").text
    print(user + " user is logged in")

    driver.find_element(By.XPATH, "/html/body/div[1]/header/div/div/div/div/div[3]/div/nav/div/ul/li[2]/a").click()
    titleAllCourses = driver.title
    print(titleAllCourses + " is the page title now")
    assert titleAllCourses == "All Courses – Alchemy LMS"

    count = len(driver.find_elements(By.XPATH,"//div[contains(@class, 'ld_course_grid col-sm-8 col-md-4')]"))
    print (str(count) + " courses are present")

    driver.find_element(By.XPATH, "//*[contains(@href,'https://alchemy.hguy.co/lms/contact/')]").click()
    print ("you have reached contact-us page")
    driver.find_element(By.ID , 'wpforms-8-field_0').send_keys("Shashank Shanker")
    driver.find_element(By.ID , 'wpforms-8-field_1').send_keys("shashank.shanker@ibm.com")
    driver.find_element(By.ID , 'wpforms-8-field_3').send_keys("Help Required with courses...")
    driver.find_element(By.ID, 'wpforms-8-field_2').send_keys("How are you doing today")
    driver.find_element(By.ID, 'wpforms-submit-8').click()
    print ("you have successfully submitted query")
    message = driver.find_element(By.XPATH, '/html/body/div[1]/div/div/div/main/article/div/section[4]/div[2]/div[2]/div[2]/div[2]/p').text
    print ("After submission, this message has been displayed : " + message)

    driver.find_element(By.XPATH, "/html/body/div[1]/header/div/div/div/div/div[3]/div/nav/div/ul/li[2]/a").click()
    driver.find_element(By.XPATH, "//*[contains(@class,'btn btn-primary')]").click()
    driver.find_element(By.XPATH, "//div[contains(@class, 'ld-item-title')]").click()
    driver.find_element(By.XPATH, "//input[contains(@class, 'learndash_mark_complete_button')]").click()
    print ("Course completed")