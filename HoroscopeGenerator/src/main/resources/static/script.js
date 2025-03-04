function getHoroscope() {
    const zodiacSign = document.getElementById('zodiacSign').value;
    const resultDiv = document.getElementById('horoscopeResult');

    resultDiv.innerHTML = '<div class="loading">🔮 Loading your horoscope...</div>';

    fetch(`http://localhost:8080/api/horoscope/generate/${zodiacSign}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            resultDiv.innerHTML = `
                <div class="horoscope">
                    <strong>Date:</strong> ${data.date}<br>
                    <strong>Horoscope:</strong> ${data.description}
                </div>
            `;
        })
        .catch(error => {
            resultDiv.innerHTML = '<div class="error">❌ Failed to fetch horoscope. Please try again later.</div>';
            console.error('Error:', error);
        });
}