// Chamada do Express
const express = require('express');

// Instancia da aplicação na constante app
const app = express();

// Carregar na rota
const indexRoutes = require('./routes/index-routes');
app.use('/', indexRoutes);

module.exports = app;