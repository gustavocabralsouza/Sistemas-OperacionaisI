import threading
from random import randint
from time import sleep


class Carro(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.semaforo = threading.Lock()

    @classmethod
    def andar(cls, idt):
        sentido = ["frente", "esquerda", "direita"]
        direcao = sentido[randint(0, 2)]
        print(f"O carro {idt} está indo para a {direcao}")

    def run(self) -> None:
        try:
            self.semaforo.acquire()
            sleep(1)
            self.andar(self.native_id)
        except Exception as e:
            print(e)
        finally:
            self.semaforo.release()


if __name__ == '__main__':
    for i in range(4):
        t = Carro()
        t.start()
