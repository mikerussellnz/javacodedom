try {
    File.maybeThrows();
    int a = 5;
} catch (IOException e) {
    System.out.println("An error occured, caught it");
} catch (SomeOtherException e) {
    System.out.println("Some other error occured, caught it");
} finally {
    System.out.println("An error occured, cleanup");
}