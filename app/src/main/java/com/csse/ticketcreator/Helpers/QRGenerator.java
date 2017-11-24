package com.csse.ticketcreator.Helpers;

import android.graphics.Bitmap;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

/**
 * This class is a helper class to generate QR Code for Travel Card ID
 *
 * @author Nishan
 * @version 1.0
 * @see QRGEncoder
 */

public class QRGenerator {
    public static Bitmap getQRCodeBitmap(String content, int dimension) throws WriterException {
        // Initializing the QR Encoder with value to be encoded, type required and Dimension
        QRGEncoder qrgEncoder = new QRGEncoder(content, null, QRGContents.Type.TEXT, dimension);
        // Getting QR-Code as Bitmap
        return qrgEncoder.encodeAsBitmap();
    }
}
