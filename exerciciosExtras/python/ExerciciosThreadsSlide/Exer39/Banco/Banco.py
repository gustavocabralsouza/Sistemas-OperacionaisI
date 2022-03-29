from clientes import Cliente


class Banco:
    def __init__(self):
        self.cliente = None
        self.AGENCIA = 1111

    def cadastrar_cliente(self, nome: str = " ", idade: int = 0, RG: str = ' ', CPF: int = 0):
        self.cliente = Cliente(nome, idade, RG, CPF)
        return self.cliente
    
    def cadastrar_conta(self, tipo: str, agencia, conta):
        if self.autenticar(tipo) is not None:
            raise TypeError("Agencia invalida")
        if tipo.lower() == "corrente":
            self.cliente.cadastrar_corrente(agencia, conta)
        if tipo.lower() == "poupança":
            self.cliente.cadastrar_pounpanca(agencia, conta)

    def autenticar(self, tipo):
        if tipo == "corrente":
            if self.cliente.conta_corrente.agencia == self.AGENCIA:
                pass
            else:
                return "O número da agencia não é deste banco"
        if tipo == "poupança":
            if self.cliente.conta_poupanca.agencia == self.AGENCIA:
                pass
            else:
                return "O número da agencia não é deste banco"


if __name__ == '__main__':
    banco = Banco()
    cliente = banco.cadastrar_cliente("Jhonattan", 19, "124536", 124025)
    cliente.cadastrar_pounpanca(agencia=1111, conta=1245)
    cliente.cadastrar_corrente(agencia=1111, conta=2556)
    cliente.conta_poupanca.depoistar(100)
    cliente.conta_poupanca.sacar(10)
    print(cliente.conta_corrente.conta)
