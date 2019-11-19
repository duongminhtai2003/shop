package edu.vinaenter.models;

public class GiftCode {
		private Integer id;
		private String name;
		private Integer percent;
		private Integer amount;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getPercent() {
			return percent;
		}
		public void setPercent(Integer percent) {
			this.percent = percent;
		}
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
		public GiftCode(Integer id, String name, Integer percent, Integer amount) {
			super();
			this.id = id;
			this.name = name;
			this.percent = percent;
			this.amount = amount;
		}
		public GiftCode() {
			super();
		}
		
		
}
