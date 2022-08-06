using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Huffman
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }
        static string translate(string original)
        {
            string newStr = "";
            for (int i = 0; i <= original.Length - 1; i++)
                for (int j = 0; j <= signTable.Length - 1; j++)
                    if (original.Substring(i, 1) == signTable[j].ToString())
                        newStr += keyTable[j];
            return newStr;
        }
        static void MakeKey(HuffmanTree tree, string code)
        {
            int pos = 0;
            if (tree.LeftChild == null)
            {
                signTable[pos] = Convert.ToInt32(tree.Letter);

                keyTable[pos] = Convert.ToInt32(code);
                pos++;
            }
            else
            {
                MakeKey(tree.LeftChild, code + "0");
                MakeKey(tree.RightChild, code + "1");
            }
        }
        public static int[] signTable;
        public static int[] keyTable;
        public void Main()
        {
            string input;
            // Console.Write("Enter a string to encode: ");
            input = TextBox1.Text;
            TreeList treeList = new TreeList();
            for (int i = 0; i < input.Length; i++)
                treeList.AddLetter(input.Substring(i, 1));
            //treeList.SortTree();
            signTable = new int[input.Length];
            keyTable = new int[input.Length];
            while (treeList.Count > 1) /////////////////////////////////
                treeList.MergeTree();
            MakeKey(treeList.RemoveTree(), "");
            string newStr = translate(input);
            for (int i = 0; i <= signTable.Length - 1; i++)
                Console.WriteLine(signTable[i] + ": " +keyTable[i]);
            Result.Content += newStr;
            //Console.WriteLine("The original string is " + input.Length * 16 + " bits long.");
            //Console.WriteLine("The new string is " + newStr.Length + " bits long.");
            //Console.WriteLine("The coded string looks like this:" + newStr);
        }
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Main();
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
        }
    }
}
