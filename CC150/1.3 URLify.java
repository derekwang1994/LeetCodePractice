// Write a method to replace all spaces in a string with '%20'.

public void URLify(char[] str, int trueLength){

  int spaceCount=0, index, i=0;

  for(int i=0; i<trueLength; i++){
    if(char[i]==' '){
      spaceCount++;
    }
  }

  index = trueLength + spaceCount*2;

  for(int i=trueLength-1; i>=0; i--){
    if(str[i]==' '){
      str[index-1] = '0';
      str[index-2] = '2';
      str[index-3] = '%';
      index-3;
    }else{
      str[index] = str[i];
      index--;
    }
  }
}
