package buoniecattivi;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.StickerReferenceToSend;
import com.botticelli.bot.request.methods.types.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class BuoniCattiviBot extends Bot {

    private HashSet<TelegramSticker> buoniSet;
    private HashSet<TelegramSticker> cattiviSet;
    private ReplyKeyboardMarkupWithButtons buoniCattiviKeyboard;
    private TelegramSticker stickerToAdd;
    private Random rand;


    public BuoniCattiviBot(String token) {
        super(token);
        buoniSet = new HashSet<>();
        cattiviSet = new HashSet<>();
        rand = new Random();

        setStickersSet("buoni.txt", buoniSet);
        setStickersSet("cattivi.txt", cattiviSet);

        List<List<KeyboardButton>> keyboard = new ArrayList<>();
        List<KeyboardButton> line = new ArrayList<>();
        line.add(new KeyboardButton("\uD83D\uDE07"));
        line.add(new KeyboardButton("\uD83D\uDE08"));
        line.add(new KeyboardButton("No Grazie"));
        keyboard.add(line);
        buoniCattiviKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
        buoniCattiviKeyboard.setResizeKeyboard(true);
    }

    private void setStickersSet(String fileName, HashSet<TelegramSticker> stickerSet)
    {
        File stickerFile = new File(fileName);
        try (Scanner s = new Scanner(stickerFile))
        {
            while (s.hasNext())
            {
                String[] telegramStickerParameters = s.nextLine().split(";");
                stickerSet.add(new TelegramSticker(telegramStickerParameters[0], telegramStickerParameters[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void textMessage(Message message) {

        StickerReferenceToSend stickerToSend;
        switch (ComandiBOT.fromString(message.getText()))
        {

            case RANDOMBUONO:
                stickerToSend = new StickerReferenceToSend(message.getFrom().getId(), getRandomStickerFromSet(buoniSet));
                sendStickerbyReference(stickerToSend);
                break;
            case RANDOMCATTIVO:
                stickerToSend = new StickerReferenceToSend(message.getFrom().getId(), getRandomStickerFromSet(cattiviSet));
                sendStickerbyReference(stickerToSend);
                break;
            case RANDOM:
                int moneta = rand.nextInt(2);
                if (moneta == 0)
                    stickerToSend = new StickerReferenceToSend(message.getFrom().getId(), getRandomStickerFromSet(buoniSet));
                else
                    stickerToSend = new StickerReferenceToSend(message.getFrom().getId(), getRandomStickerFromSet(cattiviSet));
                sendStickerbyReference(stickerToSend);
                break;
            case ERRORE:
                break;
        }

        if(stickerToAdd == null)
            return;
        MessageToSend answer;
        switch (PulsantiTastiera.fromString(message.getText()))
        {
            case BUONI:
                answer = new MessageToSend(message.getFrom().getId(), "Aggiunto sticker ai buoni!");
                answer.setReplyMarkup(new ReplyKeyboardRemove());
                sendMessage(answer);
                buoniSet.add(stickerToAdd);
                try {
                    Files.write(Paths.get("buoni.txt"), ("\n" + stickerToAdd.toString()).getBytes(), StandardOpenOption.APPEND);
                }catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case CATTIVI:
                answer = new MessageToSend(message.getFrom().getId(), "Aggiunto sticker ai cattivi!");
                answer.setReplyMarkup(new ReplyKeyboardRemove());
                sendMessage(answer);
                cattiviSet.add(stickerToAdd);
                try {
                    Files.write(Paths.get("cattivi.txt"), ("\n" + stickerToAdd.toString()).getBytes(), StandardOpenOption.APPEND);
                }catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case NO:
                answer = new MessageToSend(message.getFrom().getId(), "Va bene, lo ignorerò");
                answer.setReplyMarkup(new ReplyKeyboardRemove());
                sendMessage(answer);
                break;
            case ERRORE:
                return;
        }
        stickerToAdd = null;
    }

    private String getRandomStickerFromSet(HashSet<TelegramSticker> set)
    {
        int index = rand.nextInt(set.size());
        Iterator<TelegramSticker> iter = set.iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next().getIdToSend();
    }

    @Override
    public void audioMessage(Message message) {

    }

    @Override
    public void videoMessage(Message message) {

    }

    @Override
    public void voiceMessage(Message message) {

    }

    @Override
    public void stickerMessage(Message message) {
        System.out.print(message.getSticker().getFile_unique_id());
        System.out.println(";" + message.getSticker().getFileID());
        TelegramSticker sticker = new TelegramSticker((message.getSticker().getFile_unique_id()), message.getSticker().getFileID());
        if(buoniSet.contains(sticker))
        {
            sendMessage(new MessageToSend(message.getFrom().getId(), "Fa parte dei buoni \uD83D\uDE07"));
            return;
        }
        if(cattiviSet.contains(sticker))
        {
            sendMessage(new MessageToSend(message.getFrom().getId(), "Fa parte dei cattivi \uD83D\uDE08"));
            return;
        }
        MessageToSend addStickerMessage = new MessageToSend(message.getFrom().getId(), "Non conosco questo sticker\nVuoi aggiungerlo?");
        addStickerMessage.setReplyMarkup(buoniCattiviKeyboard);
        sendMessage(addStickerMessage);
        stickerToAdd = sticker;
    }

    @Override
    public void documentMessage(Message message) {

    }

    @Override
    public void photoMessage(Message message) {

    }

    @Override
    public void diceMessage(Message message) {

    }

    @Override
    public void contactMessage(Message message) {

    }

    @Override
    public void locationMessage(Message message) {

    }

    @Override
    public void venueMessage(Message message) {

    }

    @Override
    public void newChatMemberMessage(Message message) {

    }

    @Override
    public void newChatMembersMessage(Message message) {

    }

    @Override
    public void leftChatMemberMessage(Message message) {

    }

    @Override
    public void newChatTitleMessage(Message message) {

    }

    @Override
    public void newChatPhotoMessage(Message message) {

    }

    @Override
    public void groupChatPhotoDeleteMessage(Message message) {

    }

    @Override
    public void groupChatCreatedMessage(Message message) {

    }

    @Override
    public void inLineQuery(InlineQuery inlineQuery) {

    }

    @Override
    public void chose_inline_result(ChosenInlineResult chosenInlineResult) {

    }

    @Override
    public void callback_query(CallbackQuery callbackQuery) {

    }

    @Override
    public void gameMessage(Message message) {

    }

    @Override
    public void videoNoteMessage(Message message) {

    }

    @Override
    public void pinnedMessage(Message message) {

    }

    @Override
    public void preCheckOutQueryMessage(PreCheckoutQuery preCheckoutQuery) {

    }

    @Override
    public void shippingQueryMessage(ShippingQuery shippingQuery) {

    }

    @Override
    public void invoiceMessage(Message message) {

    }

    @Override
    public void successfulPaymentMessage(Message message) {

    }

    @Override
    public void routine() {

    }
}
