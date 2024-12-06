function validateForm() {
        const username = document.getElementById('username');
        const post = document.getElementById('post');
        const phoneNumber = document.getElementById('phoneNumber');
        const email = document.getElementById('email');
        
        const namePattern = /^[A-Za-z\s]+$/;
        const phonePattern = /^\d{10}$/;
        const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        
        if (!namePattern.test(username.value)) {
            alert('Username should contain only letters.');
            username.focus();
            return false;
        }
        
        if (!namePattern.test(post.value)) {
            alert('Post should contain only letters.');
            post.focus();
            return false;
        }
        
        if (!phonePattern.test(phoneNumber.value)) {
            alert('Phone Number should contain exactly 10 digits.');
            phoneNumber.focus();
            return false;
        }
        
        if (!emailPattern.test(email.value)) {
            alert('Please enter a valid email address.');
            email.focus();
            return false;
        }
        
        return true;
}