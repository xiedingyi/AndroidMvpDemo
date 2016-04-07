package com.norman.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

/**
 * Tools for handler picture
 *
 * @author Ryan.Tang
 *
 */
public final class ImageTools  extends Activity{

    /**
     * Transfer drawable to bitmap
     *
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Bitmap to drawable
     *
     * @param bitmap
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Drawable bitmapToDrawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    /**
     * Input stream to bitmap
     *
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static Bitmap inputStreamToBitmap(InputStream inputStream)
            throws Exception {
        return BitmapFactory.decodeStream(inputStream);
    }

    /**
     * Byte transfer to bitmap
     *
     * @param byteArray
     * @return
     */
    public static Bitmap byteToBitmap(byte[] byteArray) {
        if (byteArray.length != 0) {
            return BitmapFactory
                    .decodeByteArray(byteArray, 0, byteArray.length);
        } else {
            return null;
        }
    }

    /**
     * Byte transfer to drawable
     *
     * @param byteArray
     * @return
     */
    public static Drawable byteToDrawable(byte[] byteArray) {
        ByteArrayInputStream ins = null;
        if (byteArray != null) {
            ins = new ByteArrayInputStream(byteArray);
        }
        return Drawable.createFromStream(ins, null);
    }

    /**
     * Bitmap transfer to bytes
     *
     * @param byteArray
     * @return
     */
    public static byte[] bitmapToBytes(Bitmap bm) {
        byte[] bytes = null;
        if (bm != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
            bytes = baos.toByteArray();
        }
        return bytes;
    }

    /**
     * Drawable transfer to bytes
     *
     * @param drawable
     * @return
     */
    public static byte[] drawableToBytes(Drawable drawable) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        byte[] bytes = bitmapToBytes(bitmap);
        ;
        return bytes;
    }

    /**
     * Base64 to byte[]
     //	 */
    //	public static byte[] base64ToBytes(String base64) throws IOException {
    //		byte[] bytes = Base64.decode(base64);
    //		return bytes;
    //	}
    //
    //	/**
    //	 * Byte[] to base64
    //	 */
    //	public static String bytesTobase64(byte[] bytes) {
    //		String base64 = Base64.encode(bytes);
    //		return base64;
    //	}

    /**
     * 旋转图片
     *
     * @param angle 角度
     * @return Bitmap
     */
    public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
        // 旋转图片 动作
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        // 创建新的图片
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizedBitmap;
    }

    /**
     * Create reflection images
     *  倒影图片
     * @param bitmap
     * @return
     */
    public static Bitmap createReflectionImageWithOrigin(Bitmap bitmap) {
        final int reflectionGap = 4;
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);

        Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, h / 2, w,
                h / 2, matrix, false);

        Bitmap bitmapWithReflection = Bitmap.createBitmap(w, (h + h / 2),
                Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmapWithReflection);
        canvas.drawBitmap(bitmap, 0, 0, null);
        Paint deafalutPaint = new Paint();
        canvas.drawRect(0, h, w, h + reflectionGap, deafalutPaint);

        canvas.drawBitmap(reflectionImage, 0, h + reflectionGap, null);

        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,
                bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff,
                0x00ffffff, TileMode.CLAMP);
        paint.setShader(shader);
        // Set the Transfer mode to be porter duff and destination in
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        // Draw a rectangle using the paint with our linear gradient
        canvas.drawRect(0, h, w, bitmapWithReflection.getHeight()
                + reflectionGap, paint);

        return bitmapWithReflection;
    }

    /**
     * Get rounded corner images
     *  带圆角图片
     * @param bitmap
     * @param roundPx
     *            5 10
     * @return
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Bitmap output = Bitmap.createBitmap(w, h, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, w, h);
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    /**
     * Resize the bitmap
     *  剪切 图片成固定大小
     * @param bitmap
     * @param width
     * @param height
     * @return Bitmap
     */
    public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) width / w);
        float scaleHeight = ((float) height / h);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return newbmp;
    }


    /**
     * Resize the drawable
     * 剪切图片成固定大小
     * @param drawable
     * @param w
     * @param h
     * @return Drawable
     */
    @SuppressWarnings("deprecation")
    public static Drawable zoomDrawable(Drawable drawable, int w, int h) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap oldbmp = drawableToBitmap(drawable);
        Matrix matrix = new Matrix();
        float sx = ((float) w / width);
        float sy = ((float) h / height);
        matrix.postScale(sx, sy);
        Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height,
                matrix, true);
        return new BitmapDrawable(newbmp);
    }

    /**
     * 从SDCard获取对应图片
     * @param photoName 图片名称
     * @param path 图片文件夹地址
     * @return Bitmap
     */
    public static Bitmap getPhotoFromSDCard(String path,String photoName){
        Bitmap photoBitmap = BitmapFactory.decodeFile(path + "/" +photoName +".png");
        if (photoBitmap == null) {
            return null;
        }else {
            return photoBitmap;
        }
    }

    /**
     * 获取适屏大小
     * @param path 路径
     * @return Bitmap
     */
    public  static  Bitmap getFitBitmap(String path,int width,int heith)
    {
        Bitmap bitmap = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inSampleSize = 2;
            options.inJustDecodeBounds = false;//true它仅仅会把它的宽，高取回来给你，这样就不会占用太多的内存，也就不会那么频繁的发生OOM了。
            options.inPurgeable = true;//让系统能及时回收内存
            options.inInputShareable =true;
            options.inPreferQualityOverSpeed= false;//不使用解码速度
            options.inDither=false;    /*不进行图片抖动处理*/
            options.inPreferredConfig = Config.RGB_565;//可把默认值ARGB_8888改为RGB_565,节约一半内存
            bitmap =BitmapFactory.decodeStream(fis,null,options);
        } catch (Exception e) {
            bitmap = null;
        }
        return bitmap;



//		BitmapFactory.Options opts =  new  BitmapFactory.Options();
//		opts.inJustDecodeBounds =  true ;
//		//BitmapFactory.decodeFile(path, opts);
//		opts.inSampleSize = computeSampleSize(opts, - 1 ,  width*heith );
//		Log.e("bili", opts.inSampleSize+"");
//		opts.inJustDecodeBounds =  false ;
//		try  {
//			Bitmap bmp = BitmapFactory.decodeFile(path, opts);
//			return bmp;
//		}  catch  (OutOfMemoryError err) {
//
//		}
//		return null;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        int initialSize = computeInitialSampleSize(options, minSideLength,maxNumOfPixels);
        int roundedSize;
        if (initialSize <= 8 ) {
            roundedSize = 1;
            while (roundedSize < initialSize) {
                roundedSize <<= 1;
            }
        } else {
            roundedSize = (initialSize + 7) / 8 * 8;
        }
        return roundedSize;
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options,int minSideLength, int maxNumOfPixels) {
        double w = options.outWidth;
        double h = options.outHeight;

        int lowerBound = (maxNumOfPixels == -1) ? 1 :
                (int) Math.ceil(Math.sqrt(w * h / maxNumOfPixels));
        int upperBound = (minSideLength == -1) ? 128 :
                (int) Math.min(Math.floor(w / minSideLength), Math.floor(h / minSideLength));

        if (upperBound < lowerBound) {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }

        if ((maxNumOfPixels == -1) &&
                (minSideLength == -1)) {
            return 1;
        } else if (minSideLength == -1) {
            return lowerBound;
        } else {
            return upperBound;
        }
    }


    /**
     * 获取压缩图片
     * @param SampleSize
     * @return
     */
    public static Bitmap getBitmap(String filePathName,int SampleSize ){
        Bitmap bitmap = null;
        try {
            FileInputStream fis = new FileInputStream(filePathName);
            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inSampleSize = SampleSize;
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;//让系统能及时回收内存
            options.inPreferredConfig = Config.RGB_565;//可把默认值ARGB_8888改为RGB_565,节约一半内存
            bitmap =BitmapFactory.decodeStream(fis,null,options);
        } catch (Exception e) {
        }
        return bitmap;
    }





    /**
     * 获取图片
     * @param photoName
     * 图片地址
     * @return Bitmap
     */
    public static Bitmap getPhotoFromSDCard(String pathName){
        Bitmap photoBitmap = BitmapFactory.decodeFile(pathName);
        if (photoBitmap == null) {
            return null;
        }else {
            return photoBitmap;
        }
    }

    /**
     * SDCart是否存在
     * @return boolean
     */
    public static boolean checkSDCardAvailable(){
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * 查询对应路径的的照片是否存在
     * @param path 地址
     * @param photoName 图片名称
     * @return boolean
     */
    public static boolean findPhotoFromSDCard(String path,String photoName){
        boolean flag = false;

        if (checkSDCardAvailable()) {
            File dir = new File(path);
            if (dir.exists()) {
                File folders = new File(path);
                File photoFile[] = folders.listFiles();
                for (int i = 0; i < photoFile.length; i++) {
                    String fileName = photoFile[i].getName().split("\\.")[0];
                    if (fileName.equals(photoName)) {
                        flag = true;
                    }
                }
            }else {
                flag = false;
            }
            //			File file = new File(path + "/" + photoName  + ".jpg" );
            //			if (file.exists()) {
            //				flag = true;
            //			}else {
            //				flag = false;
            //			}

        }else {
            flag = false;
        }
        return flag;
    }

    /**
     * 保存图片到SDCard
     * @param photoBitmap 图片资源
     * @param photoName 图片名称
     * @param path 图片地址
     */
    public static void savePhotoToSDCard(Bitmap photoBitmap,String path,String photoName){
        if (checkSDCardAvailable()) {

            File dir = new File(path);
            if (!dir.exists()){
                dir.mkdirs();
            }
            File photoFile = new File(path , photoName);
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(photoFile);
                if (photoBitmap != null) {
                    if (photoBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream)) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                }
            } catch (FileNotFoundException e) {
                photoFile.delete();
                e.printStackTrace();
            } catch (IOException e) {
                photoFile.delete();
                e.printStackTrace();
            } finally{
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除对应文件夹下的图片
     * @param context
     * @param path
     * file:///sdcard/temp.jpg
     */
    public static void deleteAllPhoto(String path){
        if (checkSDCardAvailable()) {
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
        }
    }

    /**
     * 删除对应地址的图片
     * @param path 路径
     * @param fileName 名称
     */
    public static void deletePhotoAtPathAndName(String path,String fileName){
        if (checkSDCardAvailable()) {
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().split("\\.")[0].equals(fileName)) {
                    files[i].delete();
                }
            }
        }
    }

}