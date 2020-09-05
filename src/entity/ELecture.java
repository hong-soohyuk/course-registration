package entity;

import java.util.Scanner;

public class ELecture {
	   
			private int lecNumber;
			private String lecName;
			private String profName;
			private int creditNumber;
			private String lecInfo;

			public void read(Scanner scanner) {
				this.lecNumber = scanner.nextInt();
				this.lecName = scanner.next();
				this.profName = scanner.next();
				this.creditNumber = scanner.nextInt();
				this.lecInfo = scanner.next();
			}

			public int getLecNumber() {
				return lecNumber;
			}

			public void setLecNumber(int lecNumber) {
				this.lecNumber = lecNumber;
			}

			public String getLecName() {
				return lecName;
			}

			public void setLecName(String lecName) {
				this.lecName = lecName;
			}

			public String getProfName() {
				return profName;
			}

			public void setProfName(String profName) {
				this.profName = profName;
			}

			public int getCreditNumber() {
				return creditNumber;
			}

			public void setCreditNumber(int creditNumber) {
				this.creditNumber = creditNumber;
			}

			public String getLecInfo() {
				return lecInfo;
			}

			public void setLecInfo(String lecInfo) {
				this.lecInfo = lecInfo;
			}


}
