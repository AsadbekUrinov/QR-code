#include <iostream>
#include <fstream>
#include "qrcodegen.h"

void generateQRCode(const std::string& data, const std::string& filename) {
    const qrcodegen::QrCode qr = qrcodegen::QrCode::encodeText(data.c_str(), qrcodegen::QrCode::Ecc::MEDIUM);
    const int size = qr.getSize();

    // Output the QR Code as text to the console
    std::cout << qr.toSvgString(4) << std::endl;

    // Save the QR Code as an SVG file
    std::ofstream svgFile(filename);
    svgFile << qr.toSvgString(4);
    svgFile.close();
}

int main() {
    std::string data;
    std::cout << "Enter the text to encode as a QR code: ";
    std::getline(std::cin, data);

    std::string filename;
    std::cout << "Enter the filename to save the QR code as (e.g., qr_code.svg): ";
    std::getline(std::cin, filename);

    generateQRCode(data, filename);
    std::cout << "QR code generated and saved as " << filename << std::endl;

    return 0;
}
