class TrieNode{
    constructor(){
        //pointer array for child nodes of each node
        this.childNode = new Array(26).fill(null);
        this.wordCount = 0;
    }
}

// function to insert key in Trie
function insertKey(root, key){
    // initializing currentNode with root node
    let currentNode = root;

    // iterating over length of string
    for(let i = 0; i < key.length; i++){
        // check if node exist for current character in Trie
        if(!currentNode.childNode[key.charCodeAt(i) - 97]){
            // if node doesn't exist then create new node
            let newNode = new TrieNode();
            // keeping reference for newly created node
            currentNode.childNode[key.charCodeAt(i) - 97] = newNode;
        }
        // now moving currentNode pointer to newly created node
        currentNode = currentNode.childNode[key.charCodeAt(i) - 97];
    }
    // incrementing wordCount for last currentNode pointer
    // implies that there is a string ending at currentNode
    currentNode.wordCount++;
}

// function to search key in Trie
function searchKey(root, key){
    // initializing currentNode with root node
    let currentNode = root;

    // iterating over length of string
    for(let i = 0; i < key.length; i++){
        // check if node exist for current character in Trie
        if(!currentNode.childNode[key.charCodeAt(i) - 97]){
            // given word does not exist in Trie
            return false;
        }
        // move currentNode pointer to already existing node for current character
        currentNode = currentNode.childNode[key.charCodeAt(i) - 97];
    }
    return currentNode.wordCount > 0;
}

// function to delete key from Trie
function deleteKey(root, word){
    let currentNode = root;
    let lastBranchNode = null;
    let lastBranchChar = 'a';

    for(let i = 0; i < word.length; i++){
        // check if node exist for current character in Trie
        if(!currentNode.childNode[word.charCodeAt(i) - 97]){
            return false;
        }
        // check if there is more than one branch at current node
        else{
            let count = 0;
            for(let j = 0; j < 26; j++){
                if(currentNode.childNode[j]){
                    count++;
                }
            }
            // if there is more than one branch then store the node and character
            if(count > 1){
                lastBranchNode = currentNode;
                lastBranchChar = word[i];
            }
            // move currentNode pointer to already existing node for current character
            currentNode = currentNode.childNode[word.charCodeAt(i) - 97];
        }
    }
    // checking if there is more than one branch at current node
    let count = 0;
    for(let i = 0; i < 26; i++){
        if(currentNode.childNode[i]){
            count++
        }
    }

    // Case 1: The deleted word is a prefix of other words in Trie
    if(count > 0){
        currentNode.wordCount--;
        return true;
    }
    // Case 2: The deleted word shares a common prefix with other words in Trie
    else if(lastBranchNode){
        lastBranchNode.childNode[lastBranchChar.charCodeAt(0) - 97] = null;
        return true;
    }
    // Case 3: The deleted word does not share any common prefix with other words in Trie
    else{
        root.childNode[word.charCodeAt(0) - 97] = null;
        return true;
    }
}

// driver code
function main(){
    // making a root node for Trie
    let root = new TrieNode();

    // stores the strings that we want to insert in Trie
    let inputStrings = ["and", "ant", "do", "geek", "dad", "ball"];

    // number of insert operations in Trie
    let n = inputStrings.length;
    for(let i = 0; i < n; i++){
        insertKey(root, inputStrings[i]);
    }

    // stores the strings that we want to search in Trie
    let searchQueryStrings = ["do", "geek", "bat"];

    // number of search operations in Trie
    let searchQueries = searchQueryStrings.length;
    for(let i = 0; i < searchQueries; i++){
        console.log("Query String:", searchQueryStrings[i]);
        if(searchKey(root, searchQueryStrings[i])){
            // the queryString is present in the Trie
            console.log("The query string is present in the Trie");
        }
        else{
            // the queryString is not present in the Trie
            console.log("The query string is not present in the Trie");
        }
    }

    // stores the strings that we want to delete from the Trie
    let deleteQueryStrings = ["geek", "tea"];

    // number of delete operations from the Trie
    let deleteQueries = deleteQueryStrings.length;
    for(let i = 0; i < deleteQueries; i++){
        console.log("Query String:", deleteQueryStrings[i]);
        if(deleteKey(root, deleteQueryStrings[i])){
            // the queryString is successfully deleted from the Trie
            console.log("The query string is successfully deleted");
        }
        else{
            // the queryString is not present in the Trie
            console.log("The query string is not present in the Trie");
        }
    }
}

main();
