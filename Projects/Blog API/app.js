const express = require('express');
const mongoose = require('mongoose');
const ejs = require('ejs');
const bodyParser = require('body-parser');
const app = express();
// const multer = require('multer');

app.use(bodyParser.urlencoded({extended : true}));
app.use(express.static('public'));
app.set('view engine','ejs');
app.use(express.static('models'))

main().catch(err => console.log(err));

async function main() {
  await mongoose.connect('mongodb://127.0.0.1:27017/PersonalisedBlog');

  // use `await mongoose.connect('mongodb://user:password@127.0.0.1:27017/test');` if your database has auth enabled
}

mongoose.set('strictQuery','true');

// app.post('/signup/:username/:name/:password/:emaidId',require("./routes/signup"))

app.get('/blog',require("./routes/blogs"));
// app.post('/login',require("./routes/Login"));



app.post("/signup",require("./routes/signup"));

app.get("/login/",require("./routes/Login"));

app.get("/blogs",require("./routes/blogs"));




app.get('/', (req, res) => {
    console.log("Kemcho India");
    res.send('Hello World!')
})
  

  let port = 3000;
  app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
  })
