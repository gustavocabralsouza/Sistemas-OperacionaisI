from contas import Conta_poupnaca, Conta_corrente
from itertools import count


class _MetaClassCliente(type):
    def __new__(mcs, name, bases, namespace):
        if name == "Cliente":
            return type.__new__(mcs, name, bases, namespace)
        if "cadastrar_pounpanca" not in namespace:
            raise SyntaxError("Falta o método cadastrar pounpanca na classe")
        else:
            if not callable(namespace["cadastrar_pounpanca"]):
                raise SyntaxError("Falta o método cadastrar pounpanca na classe")
        if "cadastrar_corrente" not in namespace:
            raise SyntaxError("Falta o método cadastrar pounpanca na classe")
        else:
            if not callable(namespace["cadastrar_corrente"]):
                raise SyntaxError("Falta o método cadastrar corente na classe")


class Pessoa:
    def __init__(self, nome="", idade=0, RG=0, CPF=0):
        if self.__class__ is Pessoa:
            raise TypeError(f"{self.__class__} não pode ser instanciada")
        self._nome = nome
        self._idade = idade
        self.__RG = RG
        self.__CPF = CPF


class Cliente(Pessoa, metaclass=_MetaClassCliente):
    def __init__(self, nome, idade, RG, CPF):
        super(Cliente, self).__init__(nome, idade, RG, CPF)
        self._id_cliente = next(count(1))

    def cadastrar_pounpanca(self, agencia, conta):
        self.conta_poupanca = Conta_poupnaca(agencia, conta)

    def cadastrar_corrente(self, agencia, conta):
        self.conta_corrente = Conta_corrente(agencia, conta)


if __name__ == '__main__':
    pass
