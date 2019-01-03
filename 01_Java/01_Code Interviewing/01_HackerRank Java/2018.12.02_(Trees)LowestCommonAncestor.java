 // if(root == null){
        //     return null;
        // }
        // if(root.data == v1 || root.data == v2){
        //     return root;
        // }

        // if(lca(root, v1, v2)!= null && lca(root, v1, v2)!= null){
        //     return root;
        // }

        // //no solution found
        // return null;


        //BST
        //The value of a common ancestor has to always be 
        //between the two values in question.

        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        //Bigger than both
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }

        //Else solution already found
        return root;