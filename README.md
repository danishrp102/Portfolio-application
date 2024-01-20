# Portfolio-application
A stocks portfolio backend application to trade and view stocks, view portfolio for a user and update stocks.  

API routes:  

1) /api/v1/stocks/{stockId}  (GET)  

  -> Gives the details of a stock with id 'stockId'  

  <img width="1367" alt="Screenshot 2024-01-21 at 2 55 21 AM" src="https://github.com/danishrp102/Portfolio-application/assets/75444712/b0e60f37-4ee0-4365-b27d-5328f047dd87">  


  
2) /api/v1/stocks/upload  (POST)  


  -> Parses the bhavcopy csv file and updates the current prices of all the stocks in the database.  
  -> To update the details of the stocks, go to Postman and under the POST request options, click on Body.  
  -> Since a csv file is to be processed, click on 'form-data'. This takes in a key value pair where the key is the file name variable accepted by the controller layer and the value is the csv file.  
  -> In my code, I am taking the file input by the variable name 'file' - so for the key part, tyep 'file' and check the adjacent box. Set the input type from Text to File.  
  -> Finally, upload the csv file in the value field and hit Send.  
  

  <img width="1369" alt="Screenshot 2024-01-19 at 2 13 55 AM" src="https://github.com/danishrp102/Portfolio-application/assets/75444712/1eb522ff-2fef-429c-817e-1a4d5e5dd356">  


  
3) /api/v1/trade  (POST)  

  -> Takes userId, stockId, typeOfTransaction (buy/sell) and quantity to establish a trade  

  <img width="1371" alt="Screenshot 2024-01-19 at 2 14 57 AM" src="https://github.com/danishrp102/Portfolio-application/assets/75444712/acd88ab0-1add-4e5d-8412-13e420d854e8">  

  
  
4) /api/v1/portfolio/{userId}  (GET)  

  -> Takes userId and returns the current holdings of the user 'userId'  

  <img width="1362" alt="Screenshot 2024-01-19 at 2 16 01 AM" src="https://github.com/danishrp102/Portfolio-application/assets/75444712/66b654d0-cdbe-47bb-a572-883b7409ffd2">  

  
