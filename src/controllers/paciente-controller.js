const mongoose = require('mongoose');
const paciente = mongoose.model('saturacao');

// list
exports.listSaturacao = async (req, res) => {
  try {
    const data = await paciente.find({});
    res.status(200).send(data);
  } catch (e) {
    res.status(500).send({message: 'Falha ao carregar as menções.'});
  }
};

// create
exports.createMention = async (req, res) => {
  try {
    const mention = new paciente({
      friend: req.body.friend,
      mention: req.body.mention
    });

    console.log(mention)

    await mention.save();

    res.status(201).send({message: 'Menção cadastrada com sucesso!'});
  } catch (e) {
    res.status(500).send({message: 'Falha ao cadastrar a menção.'});
  }
};