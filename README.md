# Portfolio-application
A stocks portfolio backend application to trade and view stocks, view portfolio for a user and update stocks.


API routes:

/api/v1/stocks/retrieve
  -> Gives the stock details
/api/v1/stocks/upload
  -> Parses the bhavcopy csv file and updates the current prices of all the stocks in the database
/api/v1/trade
  -> Takes userId, stockId, typeOfTransaction (buy/sell) and quantity to establish a trade
/api/v1/portfolio/{userId}
  -> Takes userId and returns the current holdings of the user 'userId'
