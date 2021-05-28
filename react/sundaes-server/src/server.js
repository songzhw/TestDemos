const express = require('express');
const cors = require('cors');
const fs = require('fs');

const app = express();

// CORS for react app, assuming port 3000
app.use(cors({
  origin: 'http://localhost:3030',
  credentials: true
}))

// use middleware to serve static images
app.use(express.static('public'))

// read data from options file
const sundaeOptionsRaw = fs.readFileSync('./src/sundae-options.json', 'utf-8');
const sundaeOptions = JSON.parse(sundaeOptionsRaw);

app.get('/scoops', (req, resp) => {
  resp.json(sundaeOptions.iceCreamFlavors)
})

app.get('/toppings', (req, resp) => {
  resp.json(sundaeOptions.toppings)
})

app.listen(3030, () => console.log('Sundae server listening on port 3030!'))
module.exports = app;
