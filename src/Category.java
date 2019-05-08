public class Category {
    public enum category {
        FOOD("food"),
        CLOTHING("clothing");
        private String category;
        private category(String category) {
            this.category = category;
        }
        public String getCategory(){
            return category;
        }
    }
}
