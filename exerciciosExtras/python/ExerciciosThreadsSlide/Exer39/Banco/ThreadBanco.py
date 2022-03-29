import random
import threading
from Banco import Banco


class CLiente(threading.Thread):
    banco = Banco()
    cliente = banco.cadastrar_cliente("Jhonattan", 19, "124536", 124025)

    def __init__(self, conta, saldo, valor):
        threading.Thread.__init__(self)
        self.saldo = saldo
        self.conta = conta
        self.valor = valor
        self.semaforo = threading.Semaphore(1)

    def run(self) -> None:
        passe = random.randint(1,2)
        try:
            if passe == 1:
                self.cliente.cadastrar_pounpanca(agencia=1111, conta=self.conta)
                self.semaforo.acquire()
                self.cliente.conta_poupanca.depoistar(self.valor)
                print(f"Cliente {self.native_id} depositou {self.valor} conto")
                self.semaforo.release()
            if passe == 2:
                self.cliente.cadastrar_pounpanca(agencia=1111, conta=self.conta)
                self.semaforo.acquire()
                self.cliente.conta_poupanca.sacar(self.valor)
                print(f"Cliente {self.native_id} sacou {self.valor} conto")
                self.semaforo.release()
        except Exception as e:
            print(e)
        finally:
            self.semaforo.release()


if __name__ == '__main__':
    for i in range(20):
        Cli = CLiente(i, 0, 100)
        Cli.start()
