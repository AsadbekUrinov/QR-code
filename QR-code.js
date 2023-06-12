<!DOCTYPE html>
<html>
<head>
  <title>QR Code Generator</title>
  <script src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
</head>
<body>
  <h1>QR Code Generator</h1>
  <div>
    <label for="inputText">Enter the text to encode as a QR code:</label>
    <input type="text" id="inputText">
    <button onclick="generateQRCode()">Generate QR Code</button>
  </div>
  <div id="qrcode"></div>

  <script>
    function generateQRCode() {
      var inputText = document.getElementById('inputText').value;
      var qrcode = new QRCode(document.getElementById('qrcode'), {
        text: inputText,
        width: 128,
        height: 128
      });
    }
  </script>
</body>
</html>
