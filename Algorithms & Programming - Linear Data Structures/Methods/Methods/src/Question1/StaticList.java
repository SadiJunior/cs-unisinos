package Question1;

import Exceptions.*;

/**
 * Implementa��o de uma lista linear com armazenamento est�tico,
 * baseado em array.
 */
public class StaticList<E> implements List<E> {
    private E[] elements;
    private int numElements;

    /**
     * Constr�i uma lista com um tamanho m�ximo.
     * @param maxSize O tamanho m�ximo da lista
     */
    public StaticList(int maxSize) {
        elements = (E[])new Object[maxSize];
        numElements = 0;
    }

    public int numElements() {
        return numElements;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean isFull() {
        return numElements == elements.length;
    }

    public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException{
        // verifica se h� espa�o na lista
        if (isFull())
            throw new OverflowException();

        // verifica se a posi��o � v�lida
        if (pos < 0  ||  pos > numElements)
            throw new IndexOutOfBoundsException();

        // desloca para a direita os elementos necess�rios,
        // abrindo espa�o para o novo
        for (int i = numElements-1; i >= pos; i--)
            elements[i+1] = elements[i];

        // armazena o novo elemento e ajusta o total
        elements[pos] = element;
        numElements++;
    }

    public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException{
        if(isEmpty())
            throw new UnderflowException();

        // verifica se a posi��o � v�lida
        if (pos < 0  ||  pos >= numElements)
            throw new IndexOutOfBoundsException();

        // guarda uma refer?ncia tempor�ria ao elemento removido
        E element = elements[pos];

        // desloca para a esquerda os elementos necess�rios,
        // sobrescrevendo a posi��o do que est� sendo removido
        for (int i = pos; i < numElements-1; i++)
            elements[i] = elements[i+1];

        // define para null a posi��o antes ocupada pelo �ltimo,
        // para que a coleta de lixo possa atuar, e ajusta o total
        elements[numElements-1] = null;
        numElements--;

        return element;
    }

    public E get(int pos) throws IndexOutOfBoundsException{
        // verifica se a posi��o � v�lida
        if (pos < 0  ||  pos >= numElements)
            throw new IndexOutOfBoundsException();

        return elements[pos];
    }

    public int search(E element) {
        for (int i = 0; i < numElements; i++)
            if (element.equals(elements[i]))
                return i;

        // se chegar at� aqui, � porque n�o encontrou
        return -1;
    }

    // M�todo 1:
    public int contaElementos(E el) throws IllegalArgumentException {
        if (el == null) {
            throw new IllegalArgumentException();
        }

        return contaElementos(el, 0);
    }

    // Contagem recursiva
    private int contaElementos(E el, int index) {
        if (index >= this.numElements) {
            return 0;
        }

        // Se o elemento � igual, soma 1 e continua a recurs�o
        if (elements[index].equals(el)) {
            return 1 + contaElementos(el, index + 1);
        }

        // Se n�o, apenas continua a recurs�o
        return contaElementos(el, index + 1);
    }

    /**
     * Retorna uma representa��o String da lista.
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < numElements; i++)
            s += elements[i] + " ";
        return s;
    }
}