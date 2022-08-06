namespace Huffman
{
    internal class HuffmanTree
    {

        private HuffmanTree _leftChild;
        private HuffmanTree _rightChild;
        private string _letter;
        private int _freq;

        public HuffmanTree LeftChild { set { _leftChild = value; } get { return _leftChild; } }
        public HuffmanTree RightChild { set { _rightChild = value; } get { return _rightChild; } }
        public string Letter { set { _letter = value; } get { return _letter; } }
        public int Freq { set { _freq = value; } get { return _freq; } }
        public HuffmanTree()
        {

        }
        public HuffmanTree(string letter)
        {
            Letter = letter;
        }

    }
}