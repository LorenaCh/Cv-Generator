
const list = document.querySelectorAll(".list");
        function activeLink() {
            list.forEach((item) => item.classList.remove("active"));
            this.classList.add("active");
            console.log("activando un link")
        }
list.forEach((item) => item.addEventListener("click", activeLink));