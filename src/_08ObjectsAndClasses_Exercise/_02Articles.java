package _08ObjectsAndClasses_Exercise;

import java.util.Scanner;

public class _02Articles {
	public static class Article{
		private String title;
		private String content;
		private String author;

		public Article(String title, String content, String author) {
			this.title = title;
			this.content = content;
			this.author = author;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getTitle() {
			return this.title;
		}

		public String getContent() {
			return this.content;
		}

		public String getAuthor() {
			return this.author;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] inputArr = scanner.nextLine().split(", ");
		Article article = new Article(inputArr[0], inputArr[1], inputArr[2]);

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String command = scanner.nextLine();

			changeArticle(article, command);
		}
		System.out.println(article.getTitle() + " - " + article.getContent() + ": " + article.getAuthor());
	}

	private static void changeArticle(Article article, String command) {
		if(command.startsWith("Edit")) {
			String newContent = command.split(":\\s")[1];

			article.setContent(newContent);
		} else if(command.startsWith("ChangeAuthor")) {
			String newAuthor = command.split(":\\s")[1];

			article.setAuthor(newAuthor);
		} else if(command.startsWith("Rename")) {
			String newTitle = command.split(":\\s")[1];

			article.setTitle(newTitle);
		}
	}
}
