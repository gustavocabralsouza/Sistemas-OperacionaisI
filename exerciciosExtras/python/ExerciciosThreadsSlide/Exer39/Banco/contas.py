from abc import abstractmethod, ABC


class Conta(ABC):
    def __init__(self, agencia, conta, saldo=0):
        self._agencia = agencia
        self._conta = conta
        self._saldo: float = saldo

    @property
    def agencia(self):
        return self._agencia

    @agencia.setter
    def agencia(self, valor):
        self._agencia = valor

    @property
    def conta(self):
        return self._conta

    @conta.setter
    def conta(self, valor):
        self._conta = valor

    @property
    def saldo(self):
        return self._saldo

    @saldo.setter
    def saldo(self, valor: float):
        self._saldo = valor

    def depoistar(self, valor: float):
        if valor > 0:
            self._saldo += valor
        else:
            raise ValueError("Depoisto não pode ser negativo")

    @abstractmethod
    def sacar(self, valor: float):
        pass


class Conta_poupnaca(Conta):
    def __init__(self, agencia=0, conta=0, saldo=0):
        super(Conta_poupnaca, self).__init__(agencia, conta, saldo)

    def sacar(self, valor: float):
        if self.saldo < valor:
            # print("Saldo insuficiente")
            return 0
        self.saldo -= valor


class Conta_corrente(Conta):
    def __init__(self, agencia, conta, saldo=0, limite=100):
        super(Conta_corrente, self).__init__(agencia, conta, saldo)
        self.limite = limite

    def sacar(self, valor: float):
        if (self.saldo + self.limite) < valor:
            # print("Saldo insuficiente")
            if self.saldo < 0:
                print("Saldo negativado")
            return
        self.saldo -= valor
