import qrcode

def generate_qr_code(data, filename):
    qr = qrcode.QRCode(
        version=1,
        error_correction=qrcode.constants.ERROR_CORRECT_H,
        box_size=10,
        border=4,
    )
    qr.add_data(data)
    qr.make(fit=True)
    img = qr.make_image(fill_color="black", back_color="white")
    img.save(filename)

# Prompt the user for the text to encode
data = input("Enter the text to encode as a QR code: ")

# Generate and save the QR code
filename = "qr_code.png"
generate_qr_code(data, filename)
print(f"QR code generated and saved as {filename}")
