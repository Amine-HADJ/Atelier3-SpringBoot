const express = require('express');
const path = require('path');

const app = express();

const port = process.env.PORT || 3000;

app.use(express.static(path.join(__dirname)));

app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'home.html'));
});

app.listen(port, () => {
  console.log(`Frontend app is running at http://localhost:${port}`);
});
