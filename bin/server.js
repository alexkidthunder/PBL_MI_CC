/*chamada das dependências necessárias para subir o servidor HTTP*/
const app = require('../src/app');
const http = require('http');
const debug = require('debug')('nodestr:server');

// PORT // based on express-generator 
function normalizePort(val) {
  const port = parseInt(val, 10);

  if (isNaN(port)) {
    return val;
  }

  if (port >= 0) {
    return port;
  }

  return false;
}

const port = normalizePort(process.env.PORT || 3000); // Normalizar a porta
app.set('port', port);

// Função para tratamento de error
function onError(error) {
  if (error.syscall !== 'listen') {
    throw error;
  }
  
  const bind = typeof port === 'string' ? 'Pipe ' + port : 'Port ' + port;

  switch (error.code) {
    case 'EACCES':
      console.error(bind + ' requires elevated privileges');
      process.exit(1);

    case 'EADDRINUSE':
      console.error(bind + ' is already in use');
      process.exit(1);

    default:
      throw error;
  }
}

// Função para escutar o servidor
function onListening() {
  const addr = server.address();
  const bind = typeof addr === 'string' ? 'pipe ' + addr : 'port ' + addr.port;
  debug('Listening on ' + bind);
}

// Criação do server do tipo http
const server = http.createServer(app);
server.listen(port);
server.on('error', onError);
server.on('listening', onListening);
console.log(`API is alive on ${port}!`);