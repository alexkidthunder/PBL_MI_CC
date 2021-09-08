const express = require('express');
const router = express.Router();
const pacienteController = require('../controllers/paciente-controller');

router.get('/', pacienteController.listSaturacao);
router.post('/', pacienteController.createMention);

module.exports = router;