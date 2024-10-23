import java.io.File;
import java.util.Scanner;

class ReviewRunner {
    public static String[] folderContents(String folderName) { 
      File folder = new File(folderName);
      File[] files = folder.listFiles(); 

      String[] results = new String[files.length];

      for (int i = 0; i < files.length; i++) {
        File textFile = files[i];
        String temp = "";

          try {
            Scanner input = new Scanner(textFile);
            
            while(input.hasNext()) {
              temp = temp.concat(input.next() + " ");
            }

            input.close();
            temp = temp.trim();
          }

          catch(Exception e){
            System.out.println("Unable to locate " + textFile);
          }

        results[i] = temp;
    }
    return results;
  }

  public static void main(String[] args) 
  {
    String[] PotterReviews = folderContents("PotterReviews");
    int words = 0;
    double sentimentAvg = 0;
    for (String PotterReview : PotterReviews) {
      for (String word : PotterReview.split(" ")) {
        double wordSentiment = Review.sentimentVal(Review.removePunctuation(word));
        sentimentAvg += wordSentiment;
        if (wordSentiment != 0) {
          words++;
        }
      }
    }
    sentimentAvg /= words;

    System.out.println("The average sentiment is: "+ sentimentAvg);
    if (sentimentAvg < 50){
      System.out.println("The sentiment average is less than 50 meaning the majority of people do not like Harry Potter.");
    } else {
      System.out.println("The sentiment average is greater than 50 meaning the majority of people like Harry Potter.");
    }
  }
}