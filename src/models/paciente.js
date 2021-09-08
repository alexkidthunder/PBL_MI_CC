const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const schema = new Schema({
  paciente: {
    type: String,
    required: true,
    trim: true
  },
  saturacao: {
    type: Number,
    required: true
  }
});

module.exports = mongoose.model('saturacao', schema);