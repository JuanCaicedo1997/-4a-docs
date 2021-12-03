const accountTypeDefs = require('./account_type_defs');
const transactionTypeDefs = require('./transaction_type_defs');
const authTypeDefs = require('./auth_type_defs');


const schemasArrays = [authTypeDefs, accountTypeDefs, transactionTypeDefs];


module.exports = schemasArrays;