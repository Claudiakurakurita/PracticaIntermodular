document.addEventListener("DOMContentLoaded", function() {
    const tables = document.querySelectorAll('table');
    tables.forEach(table => {
        table.addEventListener('click', function(e) {
            if (e.target.tagName === 'TD') {
                const row = e.target.parentElement;
                if (row.style.backgroundColor === 'lightyellow') {
                    row.style.backgroundColor = '';
                } else {
                    row.style.backgroundColor = 'lightyellow';
                }
            }
        });
    });
});