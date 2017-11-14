package com.csse.ticketcreator.Helpers;

import android.graphics.Bitmap;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

/**
 * @author Nishan
 * @version 1.0
 */

public class QRGenerator {
    public static Bitmap getQRCodeBitmap(String content, int dimension) throws WriterException {
        Bitmap bitmap;
        // Initializing the QR Encoder with your value to be encoded, type required and Dimension
        QRGEncoder qrgEncoder = new QRGEncoder(content, null, QRGContents.Type.TEXT, dimension);
        // Getting QR-Code as Bitmap
        bitmap = qrgEncoder.encodeAsBitmap();
        return bitmap;
    }
}
