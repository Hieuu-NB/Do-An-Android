package com.example.appdoctruyentranh.off.Fragmnet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.Aciton.ItemClick;
import com.example.appdoctruyentranh.off.Adapter.AdapterDanhSachTruyen;
import com.example.appdoctruyentranh.off.Adapter.AdapterViewPage;
import com.example.appdoctruyentranh.off.ChiTietTruyenActivity;
import com.example.appdoctruyentranh.off.Model.ListAnh;
import com.example.appdoctruyentranh.off.Model.TruyenCoTich;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {

    ViewPager mViewPager;
    AdapterViewPage adapterViewPage;
    ArrayList<ListAnh> arrayList;
    CircleIndicator mCircleIndicator;
    Timer mTimer;
    ViewPager2 mViewPager2;
    AdapterDanhSachTruyen adapterDanhSachTruyen;
    ArrayList<TruyenCoTich> list;
    RecyclerView mRecyclerView;
    int image_anh_yeu_thich , idYeuThich ;
    String tenTruyenYeuThich;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.appdoctruyentranh.R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = view.findViewById(R.id.viewpgae_home);
        mViewPager2 = view.findViewById(R.id.viewpage2_trang_chu);
        mRecyclerView = view.findViewById(R.id.recy_view_danh_sach_truyen);
        mCircleIndicator = view.findViewById(R.id.CircleIndicator_home);
        arrayList = new ArrayList<>();
        list = new ArrayList<>();
        arrayList.add(new ListAnh(R.drawable.slide1));
        arrayList.add(new ListAnh(R.drawable.slide2));
        arrayList.add(new ListAnh(R.drawable.slide3));
        arrayList.add(new ListAnh(R.drawable.slide4));
        adapterViewPage = new AdapterViewPage(getActivity(),arrayList);
        mViewPager.setAdapter(adapterViewPage);
        AotuSlideImage();
        mCircleIndicator.setViewPager (mViewPager);
        adapterViewPage.registerDataSetObserver (mCircleIndicator.getDataSetObserver ());

        InsetTruyenCoTich();
        GetListTruyen();

    }
    public void GetListTruyen(){
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                adapterDanhSachTruyen = new AdapterDanhSachTruyen(getActivity(), list, new ItemClick() {
            @Override
            public void ChiTietruyen(TruyenCoTich coTich) {
                for (int i=0 ; i < list.size() ; i++){
                    if(coTich.getId() == list.get(i).getId()){
                        Intent intent = new Intent(getActivity(), ChiTietTruyenActivity.class);
                        intent.putExtra("_id",list.get(i).getId());
                        intent.putExtra("_anhTruyen",list.get(i).getImageAnhTruyen());
                        intent.putExtra("_tenTruyen",list.get(i).getTenTruyen());
                        intent.putExtra("_noiDungTruyen",list.get(i).getNoiDungTruyen());
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void YeuThich(TruyenCoTich coTich) {

            }
        });
        mRecyclerView.setAdapter(adapterDanhSachTruyen);

    }

    private void AotuSlideImage() {
        if (arrayList == null || arrayList.isEmpty() || mViewPager == null) {
            return;
        }
        if (mTimer == null) {
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int index_anh = mViewPager.getCurrentItem();
                        int int_list_image = arrayList.size() - 1;
                        if (index_anh < int_list_image) {
                            index_anh++;
                            mViewPager.setCurrentItem(index_anh);
                        } else {
                            mViewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 6000, 6000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mTimer != null ){
            mTimer.cancel ();
            mTimer = null;
        }
    }
    public void InsetTruyenCoTich(){
        list.add(new TruyenCoTich(1,R.drawable.truyen1,"Con cóc là cậu ông trời ","Thạch Sanh vốn là thái tử (con Ngọc Hoàng), được phái xuống làm con vợ chồng người nông dân nghèo khổ nhưng tốt bụng. Chàng sớm mồ côi cha mẹ, sống lủi thủi dưới gốc đa, hái củi kiếm sống qua ngày.\n" +
                "\n" +
                "Lí Thông - một người hàng rượu - thấy Thạch Sanh khỏe mạnh hắn giả vờ kết nghĩa anh em để lợi dụng. Đúng dịp Lí Thông đến lượt phải vào đền cho chằn tinh hung dữ ăn thịt, hắn bèn lừa Thạch Sanh đến nộp mạng thay cho mình. Thạch Sanh đã giết chết chằn tinh. Lí Thông lại lừa cho Thạch Sanh bỏ trốn rồi đem đầu chằn tinh vào nộp cho vua để lĩnh thưởng, được vua phong làm Quận công.\n" +
                "\n" +
                "Nhà vua có công chúa đến tuổi kén chồng. Trong ngày hội lớn, công chúa bị đại bàng khổng lồ quắp đi. Qua gốc đa chỗ Thạch Sanh đang ở, nó bị chàng dùng cung tên bắn bị thương. Thạch Sanh lần theo vết máu, biết được chỗ đại bàng ở. Vua mất công chúa, vô cùng đau khổ, sai Lí Thông đi tìm, hứa gả con và truyền ngôi cho. Lí Thông lại nhờ Thạch Sanh cứu công chúa rồi lừa nhốt chàng dưới hang sâu.\n" +
                "\n" +
                "Thạch Sanh giết đại bàng, lại cứu luôn thái tử con vua Thủy Tề bị đại bàng bắt giam trong cũi cuối hang từ lâu. Theo chân thái tử, chàng xuống thăm thuỷ cung, được vua Thuỷ Tề khoản đãi rất hậu, tặng nhiều vàng bạc nhưng chàng chỉ xin cây đàn thần rồi lại trở về gốc đa.\n" +
                "\n" +
                "Từ khi được cứu về, công chúa không cười không nói. Hồn chằn tinh và đại bàng trả thù, vu vạ cho Thạch Sanh khiến chàng bị nhốt vào ngục. Chàng đánh đàn, công chúa nghe thấy liền khỏi bệnh câm. Thạch Sanh được vua cho gọi lên. Chàng kể lại rõ mọi việc. Vua giao cho chàng xử tội mẹ con Lí Thông. Được chàng tha bổng nhưng hai mẹ con trên đường về đã bị sét đánh chết, hoá kiếp thành bọ hung."));
        list.add(new TruyenCoTich(2,R.drawable.truyen2,"Tấm Cám " , "Ngày xửa ngày xưa, có một cô Tấm xinh đẹp, dịu dàng, chịu thương chịu khó nhưng không may mắn sống trong sự ghẻ lạnh, cay độc của bà dì ghẻ sau khi bố mất sớm. Tấm phải một mình làm lụng vất vả quần quật suốt cả ngày không một phút nghỉ ngơi, trong khi cô Cám - là con của bà mẹ kế lại vô cùng lười biếng, ỷ lại, không đụng tay vào bất cứ công việc gì. Một hôm, Tấm và Cám ra đồng bắt tép. Cám do mải chơi nên chẳng bắt được một con nào, chính vì thế, Cám âm mưu cướp hết tất cả số tép bắt được của Tấm, chỉ còn lại một con cá bống.\n" +
                "\n" +
                "Tấm tủi thân quá ngồi khóc nức nở. Ông Bụt thương tình cho tấm lòng của cô Tấm, hiện lên và mách nàng mang con cá bống về nuôi. Con cá bống từ ngày ấy trở thành người bạn thân thiết tri kỷ của Tấm và được cô chia sẻ từng phần cơm ít ỏi mỗi ngày. Mẹ con Cám thấy vậy đem lòng đố kỵ lừa Tấm đi chăn trâu thật xa và giết chết con cá bống. Tấm về không thấy con cá bống đâu, đau lòng và khóc nức nở. Bụt lại hiện lên và chỉ nàng tìm nhặt xương cá, bỏ vào bốn cái lọ và đem chôn ở bốn chân giường. Nhờ có sự cứu giúp của Bụt, cô Tấm đã có xiêm y đẹp lộng lẫy để đi dự tiệc ở hoàng cung và sau này có dịp nên duyên chồng vợ với nhà vua, trở thành hoàng hậu. Mẹ con Cám thấy vậy lòng ganh ghét đố kỵ càng dâng cao. Trong lòng luôn nung nấu ý định trả thù và giành giật vị trí hoàng hậu đài các sang trọng của Tấm. Và đỉnh điểm là trong một lần Tấm về quê giỗ cha, hai mẹ con dụ Tấm trèo lên cây cau và chặt đứt cây, Tấm chết. Sau đó, Cám vào cung tiến vua thay Tấm, còn cô Tấm lần lượt biến thành con chim vàng anh, cây xoan đào, khung cửi và cuối cùng là trong quả thị để trở thành con gái của bà cụ hàng nước. Trong một lần nhà vua tình cờ ngao du đi sang đây, tình cờ thấy miếng trầu được têm khéo léo, tỉ mỉ, công phu, chàng đã ngay lập tức nhận ra vợ của mình, và cả hai cùng nhau đoàn tụ trong hạnh phúc."));
        list.add(new TruyenCoTich(3,R.drawable.truyen3,"Tìm Mẹ","Ngày xưa, ở một làng nhỏ, có một người mẹ. Người mẹ nuôi hai đứa con. Đứa nhớn là thằng Nhà lên năm. Đứa nhỏ là con Gạo lên ba.\n" +
                "\n" +
                "Khi đẻ đứa con nhớn, người bố nói:\n" +
                "\n" +
                "– Mình làm ăn suốt ngày suốt tháng mà cái nhà cũng không có mà ở. Thôi, đặt tên cho nó là Nhà để sau này nó có cái nhà trú mưa trú nắng. Người mẹ nói:\n" +
                "\n" +
                "– Thế thì đặt tên cho nó là thằng Nhà.\n" +
                "\n" +
                "Vừa nói vừa ứa nước mắt.\n" +
                "\n" +
                "Khi đẻ đứa con gái, người bố nói:\n" +
                "\n" +
                "– Mình làm ăn suốt ngày suốt tháng, mà gạo chẳng có mà ăn. Thôi, đặt tên cho nó là Gạo để sau này nó còn có hột gạo ăn.\n" +
                "\n" +
                "Người mẹ nói:\n" +
                "\n" +
                "– Thế thì đặt tên cho nó là con Gạo.\n" +
                "\n" +
                "Vừa nói vừa ứa nước mắt.\n" +
                "\n" +
                "o O o\n" +
                "Hai vợ chồng ra sức làm ăn quanh năm suốt tháng. Làm ngày không đủ phải làm cả đêm. Người bố ngày thì đi làm ruộng, đêm thì đi săn. Nhưng lúa gặt được bao nhiêu phải nộp cho Chúa làng bấy nhiêu. Hươu nai bắn được con nào phải nộp cho Chúa làng con ấy. Người mẹ thì đi mò cua bắt ốc. Cua ốc kiếm được cũng phải nộp cho Chúa làng.\n" +
                "\n" +
                "Mỗi khi Chúa làng nói thì mọi người trong làng phải cúi đầu không được nói. Chúa làng đòi gì là mọi người phải răm rắp tuân theo.\n" +
                "\n" +
                "Người bố nói:\n" +
                "\n" +
                "– Thế này thì thằng Nhà chẳng bao giờ có nhà, con Gạo chẳng bao giờ có gạo.\n" +
                "\n" +
                "Người mẹ nhìn hai đứa con, ứa nước mắt. Người bố nói:\n" +
                "\n" +
                "– Mình không có, còn chịu được. Nhưng chúng nó không có nhà, không có gạo thì chịu sao nổi. Phải cố cho con nó có gạo mà ăn, có nhà mà trú mưa trú nắng.\n" +
                "\n" +
                "Hai vợ chồng càng ra sức làm ăn quanh năm suốt tháng, ngày làm không đủ phải làm cả đêm. Chúa làng bắt nộp hết lúa, nộp hết hươu nai, nộp hết cua ốc.\n" +
                "\n" +
                "Một hôm thằng Nhà khóc tím người vì rét, con Gạo khóc lịm đi vì đói. Người bố đến lạy Chúa làng:\n" +
                "\n" +
                "– Xin Chúa làng rủ lòng thương cho con mang về một nắm lúa.\n" +
                "\n" +
                "Chúa làng trợn mắt, chỉ tay lên cây, lại chỉ tay xuống đất, nói:\n" +
                "\n" +
                "– Từ ngọn lá trên cây đến hòn sỏi dưới đất, cái gì cũng là của tao. Tao cho gì được nấy, ai xui mày đến trước mặt tao nói càn nói bậy?\n" +
                "\n" +
                "Chúa làng quát:\n" +
                "\n" +
                "– Cút đi!\n" +
                "\n" +
                "Và Chúa làng cưỡi ngựa trắng đi chơi, tiếng nhạc rung lên như tiếng vàng tiếng ngọc. Chúa làng chợt nghĩ:\n" +
                "\n" +
                "– Nó đã dám hỏi thì rồi nó cũng dám ăn cắp.\n" +
                "\n" +
                "Chúa làng quay ngựa lại, dọc đường gặp người bố đang lủi thủi về. Chúa làng đâm người bố, hất xác xuống khe sâu. Chúa làng cho là không ai biết việc này. Nhưng dưới khe sâu, người bố kêu thê thảm:\n" +
                "\n" +
                "Chúa làng giết tôi rồi! Và lá rừng rì rào: Chúa làng giết người! Núi thì thầm: Chúa làng giết người! Khe sâu róc rách: Chúa làng giết người!\n" +
                "\n" +
                "Chúa làng nghĩ:\n" +
                "\n" +
                "– Thế nào vợ con nó cũng biết.\n" +
                "\n" +
                "Chúa làng phi ngựa đi tìm giết ba mẹ con.\n" +
                "\n" +
                "o O o\n" +
                "Trên núi, dưới một cây cổ thụ, người mẹ ôm hai con. Thằng Nhà khóc tím người vì rét. Con Gạo khóc lịm đi vì đói. Người mẹ bỗng thấy ruột mình như có ai đâm. Người mẹ nói:\n" +
                "\n" +
                "– Các con đừng khóc nữa. Ruột mẹ đau quá. Các con nín đi, bố cũng sắp về.\n" +
                "\n" +
                "Thằng Nhà, con Gạo thiu thiu ngủ. Thỉnh thoảng chúng nó giật mình cựa quậy vì rận cắn. Con rận trong manh áo rách của người mẹ cắn như đốt vào da. Để khỏi động đến giấc ngủ của hai đứa con, người mẹ khẽ bảo rận:\n" +
                "\n" +
                "– Rận ơi? Đốt tao chứ đừng đốt con tao.\n" +
                "\n" +
                "Đàn rận nói:\n" +
                "\n" +
                "– Chúa làng sai chúng tao đến hút máu vợ chồng con cái mày. Nay hết máu rồi, chúng tao cũng đi đây.\n" +
                "\n" +
                "Nói xong, đàn rận kéo nhau đi. Còn một con rận con quay lại thấy mặt người mẹ võ vàng, nó dùng dằng không nỡ đi. Sau nó nói:\n" +
                "\n" +
                "– Tình cảnh chị thật đáng thương. Tôi đi mà không nỡ. Tôi báo cho chị cái tin này. Chúa làng đã giết chồng chị rồi. Chúa làng đang phi ngựa đi tìm giết nốt ba mẹ con chị đấy. Trốn đi. Nhạc ngựa Chúa làng đã gần rồi.\n" +
                "\n" +
                "o O o\n" +
                "Những ngôi sao trên trời rỏ nước mắt xung quanh ba mẹ con. Dưới chân núi, nhạc ngựa của Chúa làng vang vang, vó ngựa nện trên đá lộp cộp.\n" +
                "\n" +
                "Người mẹ đánh thức thằng Nhà và con Gạo. Người mẹ cõng Nhà trên lưng, ẵm Gạo trong tay, nhằm núi cao mà trèo. Thằng Nhà hỏi:\n" +
                "\n" +
                "– Mẹ ơi, đêm khuya mẹ cõng con đi đâu, con rét lắm. Bố đâu?\n" +
                "\n" +
                "Con Gạo hỏi:\n" +
                "\n" +
                "– Mẹ ơi, đêm khuya mẹ ôm con đi đâu, con đói lắm. Bố đâu?\n" +
                "\n" +
                "Người mẹ nói:\n" +
                "\n" +
                "– Lên núi thật cao kẻo Chúa làng đến bắt. Các con đừng nói to, Chúa làng nghe rõ.\n" +
                "\n" +
                "Người mẹ lại lo: lên núi cao, Chúa làng không bắt được nhưng lấy gì nuôi thằng Nhà, con Gạo?\n" +
                "\n" +
                "Con rận con còn ở lại trong manh áo rách người mẹ, nói:\n" +
                "\n" +
                "– Chạy vài bước nữa thì đến hang ông lão Đá. Ông lão Đá có một giỏ gạo đầy. Xin ông lão Đá một nửa.\n" +
                "\n" +
                "Người mẹ qua hang ông lão Đá. Người mẹ không dám hỏi. Ông lão Đá nói:\n" +
                "\n" +
                "– Cầm lấy nửa giỏ gạo mà nuôi con.\n" +
                "\n" +
                "Nói xong, ông lão Đá đưa cả giỏ gạo cho người mẹ.\n" +
                "\n" +
                "Người mẹ chưa kịp đỡ thì nhạc ngựa Chúa làng lại vang lên rất gấp. Ông lão Đá chạy theo người mẹ, đưa giỏ gạo và giục đi mau.\n" +
                "\n" +
                "Người mẹ cõng thằng Nhà trên lưng, ẵm con Gạo trong tay, cái giỏ gạo bên mình, trèo hết núi này đến núi khác. Tay chân người mẹ đã nát toạc vì gai và đá nhọn. Giời đã sáng. Người mẹ đứng trên cao nhìn xuống ruộng, bờ ruộng chỉ bé như cái ngón tay. Tiếng nhạc ngựa không nghe thấy nữa. Người mẹ nói với thằng Nhà:\n" +
                "\n" +
                "– Đây cao lắm rồi. Chúa làng không lên được.\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Người nhà Chúa làng có đứa lên được.\n" +
                "\n" +
                "– Sao con biết?\n" +
                "\n" +
                "– Hôm nọ con theo ông lão Đá lên đây, kiếm gỗ đẽo bắp cày. Người nhà Chúa làng đến cướp bắp cày.\n" +
                "\n" +
                "Người mẹ nghe nói, hốt hoảng:\n" +
                "\n" +
                "– Ta phải lên cao nữa.\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Mẹ để con xuống, con nhớn rồi.\n" +
                "\n" +
                "Thằng Nhà chạy lên trước. Người mẹ lại trèo, cõng con Gạo trên lưng, cái giỏ bên mình. Lên một đỉnh núi cao, nhìn xuống ruộng, bờ ruộng bé như sợi chỉ. Người mẹ nói với thằng Nhà:\n" +
                "\n" +
                "– Con có biết núi này không?\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Con biết.\n" +
                "\n" +
                "– Sao con biết.\n" +
                "\n" +
                "– Hôm nọ con theo ông lão Đá lên đây bứt mây.\n" +
                "\n" +
                "– Người nhà Chúa làng có lên được đây không?\n" +
                "\n" +
                "– Người nhà Chúa làng lên được, cướp mây của ông lão Đá.\n" +
                "\n" +
                "Người mẹ nghe nói, hốt hoảng:\n" +
                "\n" +
                "– Ta phải lên cao nữa.\n" +
                "\n" +
                "Con Gạo nói:\n" +
                "\n" +
                "– Mẹ để con xuống, con nhớn rồi.\n" +
                "\n" +
                "Thằng Nhà dắt con Gạo chạy lên trước. Người mẹ lại trèo, cái giỏ bên mình. Lên một đỉnh núi cao lắm, nhìn xuống, không thấy gì, chỉ toàn là mây trắng. Gió thổi mạnh đến nỗi thằng Nhà và con Gạo phải ôm lấy chân người mẹ. Người mẹ phải ôm chặt lấy một mỏm đá. Người mẹ hỏi thằng Nhà:\n" +
                "\n" +
                "– Con có biết núi này không?\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Con không biết.\n" +
                "\n" +
                "Người mẹ nghĩ:\n" +
                "\n" +
                "– Thế thì Chúa làng không lên được, người nhà Chúa làng không lên được. Chúa làng không giết được mẹ con ta.\n" +
                "\n" +
                "Hai đứa bé đã thiu thiu ngủ. Người mẹ để mỗi con nằm trên một đùi, mỗi tay ôm một đứa.\n" +
                "\n" +
                "o O o\n" +
                "Người mẹ nghĩ:\n" +
                "\n" +
                "– Chúa làng không lên được, nhưng ta ở đây thì ăn hết gạo của hai con. Phải xuống núi kiếm thêm gạo cho chúng nó.\n" +
                "\n" +
                "Người mẹ hát cho thằng Nhà và con Gạo ngủ say, rồi đứng dậy. Người mẹ lại nghĩ: Phải treo giỏ gạo lên cao để con nó ăn dần, treo thấp thì con nó ăn một lúc hết ngay, nó không chờ được mẹ về, nó khóc hết hơi. Người mẹ trèo lên một cây gạo rất cao, cành lá trơ trụi, và treo cái giỏ gạo lên ngọn cây. Người mẹ trèo xuống nhìn hai đứa con đang ngủ say, hát cho chúng nó ngủ say hơn nữa. Người mẹ bẻ một sào trúc dài dựa vào gốc cây để thằng Nhà con Gạo chọc giỏ lấy gạo ăn. Cuối cùng, người mẹ cởi manh áo rách đắp cho hai con.\n" +
                "\n" +
                "Con rận con không đi với người mẹ. Nó ở lại trong manh áo rách người mẹ đã cởi đắp cho hai con. Người mẹ bước đi một bước lại quay nhìn hai con, ứa nước mắt đi không đành. Con rận con bò ra khỏi manh áo rách, bò lên một cành cây ngang vai người mẹ. Người mẹ vẫn quay nhìn hai con, ứa nước mắt đi không đành. Con rận con đã bò lên ngang tai người mẹ, nói nhỏ:\n" +
                "\n" +
                "– Chị đi đi, đi tìm gạo cho thằng Nhà, con Gạo.\n" +
                "\n" +
                "Người mẹ ứa nước mắt. Con rận con lại nói:\n" +
                "\n" +
                "– Chị đi nhanh lên. Dọc đường có gặp Chúa làng thì nhằm rừng mây mà chạy vào. Rừng mây chị chạy được, Chúa làng cưỡi ngựa không chạy lên được.\n" +
                "\n" +
                "Người mẹ hỏi:\n" +
                "\n" +
                "– Liệu Chúa làng có lên đây không?\n" +
                "\n" +
                "– Chúa làng gặp chị, đuổi theo chị, thì không lên đây nữa.\n" +
                "\n" +
                "– Chúa làng cứ lên thì làm sao?\n" +
                "\n" +
                "– Thì đã có tôi.\n" +
                "\n" +
                "Người mẹ gạt nước mắt xuống núi. Một lúc nghe văng vẳng tiếng nhạc ngựa của Chúa làng. Người mẹ chạy xuống đến lưng chừng núi thì nhạc ngựa của Chúa làng cũng vang lên ở lưng chừng núi. Người mẹ thấy ngựa Chúa làng trước mặt, kêu lên một tiếng và chạy rẽ vào rừng mây. Chúa làng nghe tiếng người mẹ kêu, phi ngựa đuổi theo vào rừng mây. Dây mây chằng chịt, ngựa Chúa làng vướng mây không chạy được, Chúa làng nhảy xuống ngựa, đuổi theo người mẹ. Mây rẽ ra cho người mẹ chạy. Gai mây đâm vào tay, vào chân, vào mặt Chúa làng. Chân nó, tay nó, mặt nó chảy máu. Chúa làng phải chạy trở ra, đứng ngoài rừng mây nhìn vào, gầm thét. Người mẹ ra sức chạy cho xa, cho thật xa tiếng gầm thét của Chúa làng. Người mẹ lạc mất đường về. Chúa làng gầm thét khản cả cổ, mà vẫn không thấy người mẹ ra. Chúa làng lên ngựa. Gai mây đâm vào chân, máu chảy ra đã khô. Gai mây đâm vào tay, máu chảy ra đã khô. Gai mây đâm vào mặt, máu chảy ra đã khô. Máu khô làm thành những đường vằn vện trên chân, trên tay, trên mặt Chúa làng. Mặt Chúa làng càng thêm hung ác.\n" +
                "\n" +
                "o O o\n" +
                "Trên núi, thằng Nhà và con Gạo đã thức dậy. Hai đứa quờ tay không thấy mẹ, rụi mắt nhìn chung quanh cũng không thấy mẹ đâu. Con Gạo khóc, thằng Nhà nói:\n" +
                "\n" +
                "– Chúng ta hú to lên thì mẹ về.\n" +
                "\n" +
                "Chúng nó hú to. Tiếng vang cũng hú, con rận con nghe tiếng hú, nó bắt chước tiếng người mẹ hú, hú lên. Thằng Nhà nói:\n" +
                "\n" +
                "– Mẹ nghe tiếng chúng ta hú rồi. Mẹ sắp về đấy.\n" +
                "\n" +
                "Thằng Nhà dắt con Gạo ra gốc cây gạo, thấy giỏ gạo treo trên ngọn cây. Thằng Nhà thấy cái sào trúc, nói:\n" +
                "\n" +
                "– Mẹ treo cao để chúng ta ăn dè đây.\n" +
                "\n" +
                "Nó lấy cái sào chọc vào giỏ gạo, mấy hạt gạo rơi xuống. Hai anh em cúi xuống nhặt ăn. Ăn xong, hai đứa trẻ nhìn xuống dưới núi, chúng nó chóng mặt, lại ôm nhau, lấy manh áo rách của người mẹ đắp, rồi lại ngủ thiếp đi. Con rận con vẫn hú đều đều, ru ngủ hai đứa trẻ.\n" +
                "\n" +
                "o O o\n" +
                "Chúa làng mặt mày vằn vện, cưỡi ngựa ra khỏi rừng mây, đang định về thì nghe tiếng hú trên núi. Chúa làng phi ngựa lên. Rận con nghe tiếng nhạc ngựa, vội vã bò xuống núi đón Chúa làng. Chúa làng phi ngựa lên tới chỗ có tiếng hú, chỉ thấy một con rận con, quát:\n" +
                "\n" +
                "– Có ba mẹ con chạy qua đây không?\n" +
                "\n" +
                "Chúa làng hỏi ba lần. Ba lần, con rận con trả lời không biết. Chúa làng tức giận đùng đùng, bắt con rận con bỏ vào mồm cắn, nuốt chửng, con rận con nói:\n" +
                "\n" +
                "– Chúa làng giết người, ăn rận, không được làm người nữa. Chúa làng sẽ biến thành con hổ.\n" +
                "\n" +
                "Con rận con nói xong thì Chúa làng biến thành con hổ, mặt mày vằn vện rất hung ác. Con hổ chạy vào hang trong rừng. Dọc đường nó gặp một người con gái đi kiếm củi. Con hổ gầm lên một tiếng, nhảy tới vồ người con gái, bắt về hang. Người con gái khóc lóc. Con hổ định ăn người con gái, nhưng nó thấy người con gái mắt sáng như sao, tay dẻo như mây, nó nói:\n" +
                "\n" +
                "– Tao tha chết cho mày, nhưng tao lấy mày làm vợ.\n" +
                "\n" +
                "Người con gái khóc lóc, giãy giụa. Về đến hang, con hổ giam người con gái vào một ngăn bên. Nó chất đá chung quanh. Nó chất những tảng đá to nhất, nặng nhất chung quanh người con gái.\n" +
                "\n" +
                "Từ khi Chúa làng biến thành hổ, dân làng làm ăn đã dễ chịu hơn trước. Nhưng con hổ lại bắt dân làng mỗi ngày phải nộp cho nó một buồng gan, gan trâu hay gan lợn. Nếu không nộp thì nó sẽ bắt người. Dân làng rất căm con hổ, nhưng khiếp oai nó, nên ngày ngày phải giết trâu, giết lợn, cắt lấy buồng gan đem ra bờ suối. Ngày ngày hổ ra đấy lấy gan ăn.\n" +
                "\n" +
                "Dân làng vẫn tìm cách trừ con hổ đi, nhưng chưa có dịp.\n" +
                "\n" +
                "Thằng Nhà, con Gạo ăn hết giỏ gạo thì vừa tròn một tháng. Người mẹ vẫn chưa về. Con Gạo khóc. Thằng Nhà nói:\n" +
                "\n" +
                "– Chúng ta phải đi tìm mẹ chứ khóc mẹ cũng chẳng về.\n" +
                "\n" +
                "Thằng Nhà cõng con Gạo xuống núi. Buổi chiều, hai anh em tới một bờ suối. Con Gạo vừa khóc vừa nói:\n" +
                "\n" +
                "– Sao mãi mẹ chẳng về.\n" +
                "\n" +
                "Gạo kêu đói, Gạo khóc đòi ăn. Thằng Nhà cũng đói lắm, nhưng nó không khóc, nó nói:\n" +
                "\n" +
                "– Mẹ thế nào cũng về.\n" +
                "\n" +
                "Thằng Nhà trông trước trông sau, thấy bên bờ suối có một buồng gan lợn. Nó định nhảy ra lấy thì con hổ vừa tới. Thằng Nhà giấu con Gạo vào một bụi kín. Hai đứa trẻ nhìn ra. Con hổ ăn gan xong, vươn mình vằn một cái rồi biến vào rừng. Hai anh em phải bịt mũi vì mùi hôi tanh của con hổ. Ngày hôm sau, gần về chiều, thằng Nhà và con Gạo núp trong bụi kín, thấy một ông cụ già đem một buồng gan đến đặt bên bờ suối, cũng vẫn chỗ hôm qua. Ông cụ lấm lét nhìn xung quanh rồi đi. Xâm xẩm tối, con hổ tới ăn gan xong, nó vươn mình vằn một cái rồi biến vào rừng. Hai anh em phải bịt mũi vì mùi hôi tanh của con hổ. Ngày hôm sau nữa, gần về chiều, thằng Nhà và con Gạo núp trong bụi kín, thấy một bà lão đem một buồng gan đến đặt ở bờ suối, cũng vẫn chỗ hôm qua. Bà lão lấm lét nhìn chung quanh rồi đi. Đợi bà lão đi khỏi, Nhà nhảy ra. Gạo giữ lại, nói:\n" +
                "\n" +
                "– Đừng ra, hổ cắn chết.\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Hổ chưa tới. Anh ra lấy gan về cho em ăn đỡ đói.\n" +
                "\n" +
                "Nói xong, thằng Nhà chạy rất nhanh ra bờ suối, lấy buồng gan trở về. Con Gạo nhảy ra khỏi bụi, tíu tít nói:\n" +
                "\n" +
                "– Nhanh lên, nhanh lên, hổ sắp tới đây.\n" +
                "\n" +
                "Thằng Nhà một tay cầm buồng gan, một tay dắt Gạo, nói:\n" +
                "\n" +
                "– Vào sâu trong rừng kẻo hổ vào bắt được.\n" +
                "\n" +
                "Hai đứa vào sâu trong rừng. Thằng Nhà nhớ hồi đi với ông lão Đá. Ông lão Đá dạy nó cách đập đá lấy lửa. Nó đập đá, lửa tóe ra. Hai đứa chất củi khô làm bếp nướng gan, nướng chín đến đâu ăn đến đấy.\n" +
                "\n" +
                "Con hổ đến bờ suối như mọi khi. Không thấy buồng gan , nó gầm lên một tiếng.\n" +
                "\n" +
                "Con Gạo ôm chầm lấy anh, nói:\n" +
                "\n" +
                "– Chạy đi không hổ bắt.\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Không sợ. Nó không vào đây được.\n" +
                "\n" +
                "Con hổ sục sạo chung quanh một hồi lâu. Nó đi đến đâu thì đá băng cây đổ đến đấy, nhưng nó không vào được chỗ thằng Nhà và con Gạo. Ngày hôm sau cũng thế. Ngày hôm sau nữa cũng thế. Con hổ sục sạo chung quanh một hồi lâu. Nó đi đến đâu thì đá băng cây đổ đến đấy, nhưng nó vẫn không vào được chỗ thằng Nhà và con Gạo. Nó gầm lên, tiếng gầm lay rừng chuyển núi. Cuối cùng nó lồng lộn ra về. Thằng Nhà, con Gạo lại nướng gan, chín đến đâu ăn đến đấy. Con Gạo nói:\n" +
                "\n" +
                "– Để dành cho mẹ một miếng gan kẻo mẹ đói.\n" +
                "\n" +
                "o O o\n" +
                "Con hổ về hang, gầm thét dữ tợn. Vợ hổ sợ khiếp, chạy sang ngăn bên, ôm mặt khóc. Ngày hôm sau, con hổ ra bờ suối rất sớm. Nó nấp sau một bụi lau. Buổi chiều, nó thấy một ông lão mang buồng gan đặt bên bờ suối, lấm lét nhìn chung quanh rồi đi. Ông lão vừa đi thì có một thằng bé chạy tới xách buồng gan chạy vụt vào rừng sâu. Con hổ gầm lên:\n" +
                "\n" +
                "– Thằng bé hỗn láo, muốn sống thì để buồng gan đấy.\n" +
                "\n" +
                "Nó nhe nanh, vểnh râu, nhảy những bước nhanh như gió, đuổi theo thằng Nhà. Nó đứng xa, thấy một đống lửa to, hai đứa trẻ ngồi nướng gan, mùi thơm phưng phức. Con hổ thèm rỏ một bãi nước bọt tanh tưởi. Nó nhảy xồ vào, nhưng đá băng cây đổ, nó không vào được chỗ thằng Nhà và con Gạo. Nó gầm lên những tiếng lay rừng chuyển núi. Nó điên cuồng, lồng lộn ra về.\n" +
                "\n" +
                "Về đến hang, con hổ gầm thét dữ tợn. Vợ hổ sợ khiếp nằm trong ngăn bên, ôm mặt khóc. Con hổ quát:\n" +
                "\n" +
                "– Có hai đứa trẻ cùng giống người với mày, dám cả gan lấy gan của tao ăn. Mày vào rừng sâu, chỗ nào có lửa là chỗ chúng nó nấp, dỗ đem chúng nó về đây.\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Hổ còn không đem về được, tôi đem thế nào được?\n" +
                "\n" +
                "Con hổ há rộng mồm, nhe nanh nhọn hoắt, mắt đỏ ngầu như miếng tiết. Nó lại gầm:\n" +
                "\n" +
                "– Không đem được hai đứa trẻ về đây, thì tao bắt hết dân làng ăn gan. Vợ hổ nghe nó dọa bắt hết dân làng ăn gan, lo sợ quá đành phải đi. Nhưng vừa đi, vợ hổ vừa khóc. Vợ hổ đến chỗ hai anh em Nhà và Gạo. Hai đứa đang ngủ, ánh lửa ửng hồng trên trán thằng Nhà trên trán con Gạo. Vợ hổ nhìn hai đứa trẻ càng thương, nước mắt chảy ròng ròng. Nước mắt chảy trên trán của Nhà, trên má của Gạo. Thằng Nhà và con Gạo choàng tỉnh dậy. Chúng nó rụi mắt, thấy trước mặt là một người con gái xinh đẹp, nhưng mặt buồn buồn như mặt người mẹ. Thằng Nhà ngồi dậy, hỏi:\n" +
                "\n" +
                "– Chị là ai?\n" +
                "\n" +
                "Con Gạo cũng ngồi dậy, chạy đến nắm tay vợ hổ, hỏi:\n" +
                "\n" +
                "– Chị ở đâu đến đây?\n" +
                "\n" +
                "Vợ hổ không trả lời được, đứng khóc. Con Gạo chạy đến ôm chân vợ hổ. Thằng Nhà cũng chạy đến cầm tay vợ hổ. Thằng Nhà hỏi:\n" +
                "\n" +
                "– Chị là ai mà lại khóc?\n" +
                "\n" +
                "Con Gạo cũng hỏi:\n" +
                "\n" +
                "– Chị ở đâu đến đây mà cứ khóc mãi thế?\n" +
                "\n" +
                "Vợ hổ nghẹn ngào nói:\n" +
                "\n" +
                "– Thôi, hai em đừng hỏi nữa. Hai em cứ đi theo chị đây, chị sẽ nói cho hai em hiểu.\n" +
                "\n" +
                "Thằng Nhà hỏi:\n" +
                "\n" +
                "– Đi với chị à? Đi đâu?\n" +
                "\n" +
                "Con Gạo cũng hỏi:\n" +
                "\n" +
                "– Đi với chị à? Chị đưa em đến với mẹ em nhé.\n" +
                "\n" +
                "Mặt vợ hổ cũng buồn như mặt người mẹ. Tiếng nói của vợ hổ cũng êm dịu như tiếng nói của người mẹ. Con Gạo bằng lòng đi với vợ hổ. Thằng Nhà cũng bằng lòng.\n" +
                "\n" +
                "Hai anh em giục vợ hổ đi, vợ hổ lại không đi, đứng nguyên một chỗ, nước mắt chảy ròng ròng. Vợ hổ nghĩ:\n" +
                "\n" +
                "– Không lẽ đem hai em về cho hổ ăn gan.\n" +
                "\n" +
                "Con Gạo nóng lòng tìm mẹ, giục vợ hổ đi. Thằng Nhà cũng giục. Vợ hổ vẫn chưa chịu đi. Chợt vợ hổ nghĩ ra một cách, bảo hai em chui vào váy, rồi tiến về hang.\n" +
                "\n" +
                "Hổ thấy vợ về, hỏi:\n" +
                "\n" +
                "– Có tìm thấy chúng nó không?\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Chỉ thấy núi băng cây đổ, đống lửa vẫn cháy, hai đứa trẻ đi rồi.\n" +
                "\n" +
                "Hổ gầm lên một tiếng lay rừng chuyển núi. Vợ hổ sợ khiếp. Con Gạo bám chặt lấy thằng Nhà. Hổ nhìn váy vợ thấy lùng thùng hỏi:\n" +
                "\n" +
                "– Sao to thế kia?\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Sắp đẻ, làm buồng cho tôi đẻ.\n" +
                "\n" +
                "Hổ chỉ vào ngăn riêng của vợ hổ, bảo:\n" +
                "\n" +
                "– Cứ vào đó mà đẻ đi.\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Phải tha thêm đá vào.\n" +
                "\n" +
                "Hổ bèn đi tha đá chất đầy chung quanh ngăn của vợ hổ. Vợ hổ vào ngăn, cài cửa đá lại. Trong ngăn đá dầy, con Gạo khóc sụt sùi. Thằng Nhà hỏi vợ hổ:\n" +
                "\n" +
                "– Sao chị lại lừa chúng tôi về đây cho hổ ăn thịt chúng tôi?\n" +
                "\n" +
                "Vợ hổ lại khóc, cúi xuống chụm đầu vào hai đứa trẻ, kể lại vì sao vợ hổ bắt buộc phải đưa Nhà và Gạo về đây. Cuối cùng, vợ hổ nói:\n" +
                "\n" +
                "– Chị không đưa hai em về đây thì hổ ăn thịt hết dân làng. Chị đem hai em về đây, hai em trốn trong này với chị để tìm mưu giết hổ.\n" +
                "\n" +
                "Mặt vợ hổ buồn như mặt người mẹ. Tiếng nói của vợ hổ êm dịu như tiếng nói người mẹ. Nhà và Gạo bằng lòng trốn trong ngăn đá với vợ hổ.\n" +
                "\n" +
                "Hổ đi rừng về, nhìn vào phía ngăn đá, gầm lên, hỏi:\n" +
                "\n" +
                "– Đẻ chưa?\n" +
                "\n" +
                "Vợ hổ chưa kịp trả lời, nó đã phồng mũi lên. Nó ngửi thấy hơi trẻ con, nó gầm:\n" +
                "\n" +
                "– Đẻ người à? Mấy đứa? Đem ra đây.\n" +
                "\n" +
                "Vợ hổ trả lời:\n" +
                "\n" +
                "– Hai đứa, không đem ra được. Nó nhỏ, ra gió nó chết.\n" +
                "\n" +
                "– Không đem ra thì mở cửa tao vào.\n" +
                "\n" +
                "– Vào không được, nó nhỏ, nó thấy bố hổ, nó sợ nó chết.\n" +
                "\n" +
                "– Nó nhỏ, gan nó to chừng nào?\n" +
                "\n" +
                "– Nó nhỏ, gan nó bằng đốt tay.\n" +
                "\n" +
                "Hổ liếm mép bỏ đi, nghe xa xa có tiếng đá băng, cây đổ. Vợ hổ kể lại chuyện bị hổ bắt ép làm vợ như thế nào cho hai đứa trẻ nghe. Thằng Nhà cũng kể tình cảnh nhà mình cho vợ hổ nghe. Con Gạo ôm chặt lấy thằng Nhà, thằng Nhà ôm chặt lấy vợ hổ, vợ hổ ôm chặt lấy hai em. Từ đôi mắt vợ hổ sáng như sao, hai dòng nước mắt chảy ra trong như nước suối, rơi xuống bàn tay nhỏ của con Gạo và thằng Nhà. Con Gạo hỏi:\n" +
                "\n" +
                "– Mẹ em đâu?\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Các em thế nào cũng tìm thấy mẹ. Chị thế nào cũng thấy nhà.\n" +
                "\n" +
                "Vợ hổ lẻn ra, vào rừng trảy muỗm về cùng hai em ăn. Ăn xong hai đứa trẻ ngủ. Vợ hổ ngồi nhìn hai em, thấy chúng nó hiền lành, thương chúng nó bơ vơ, vợ hổ lại khóc. Vợ hổ cất tiếng êm ái ru cho hai em ngủ say.\n" +
                "\n" +
                "o O o\n" +
                "Hôm sau hổ lại hỏi:\n" +
                "\n" +
                "– Đã nhớn chưa? Đem một đứa ra đây tao ăn gan.\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Còn bé lắm. Chưa nhớn được là bao. Ăn bây giờ chẳng bõ.\n" +
                "\n" +
                "Ngày hôm sau, hổ lại hỏi. Vợ hổ lại trả lời như thế. Hổ gầm lên, làm cho cả hang đá rung lên như sấm động. Hổ nói:\n" +
                "\n" +
                "– Mày không được nói quanh. Tao hẹn một ngày nữa. Ngày mai, mày không đưa một đứa ra thì tao sẽ phá cửa vào lôi cả ba đứa chúng mày ra ăn một lúc.\n" +
                "\n" +
                "Nói xong hổ ra đi, nghe xa xa đá băng cây đổ ầm ầm. Ba người trong hang ôm nhau khóc. Con Gạo nói:\n" +
                "\n" +
                "– Mẹ ở đâu, mẹ về đón con, hổ nó sắp ăn gan con rồi.\n" +
                "\n" +
                "Lúc này người mẹ thấy nhói đau trong ruột. Người mẹ đã đi lùng hết rừng núi, đầu sông ngọn nguồn để tìm con, nhưng không gặp. Ngày đêm người mẹ chỉ khóc, mắt người mẹ đã mờ đi.\n" +
                "\n" +
                "Thằng Nhà lấy tay gạt nước mắt, nói với vợ hổ:\n" +
                "\n" +
                "– Chị ra cắt lấy một miếng gan ở bờ suối về, ngày mai hổ hỏi thì đưa ra cho nó, bảo rằng gan người bé hơn gan trâu.\n" +
                "\n" +
                "Vợ hổ ra bờ suối cắt lấy một miếng gan trâu đem về. Thằng Nhà nói:\n" +
                "\n" +
                "– Chị lấy ba gai mây nhét kín vào trong miếng gan, hổ ăn gan, gai mây sẽ đâm thủng ruột hổ.\n" +
                "\n" +
                "Ngày hôm sau, hổ gầm:\n" +
                "\n" +
                "– Đem một đứa ra đây để tao ăn gan.\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Tôi giết một đứa rồi. Đây đã sẵn buồng gan của nó để bố hổ ăn.\n" +
                "\n" +
                "Hổ cười, mặt hổ cười lại càng xấu xí, dữ tợn. Hổ khen vợ hổ tốt. Vợ hổ đưa miếng gan cho hổ. Hổ hỏi:\n" +
                "\n" +
                "– Sao gan không tươi?\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Gan người không tươi bằng gan trâu, gan lợn, nhưng bổ hơn gan trâu, gan lợn.\n" +
                "\n" +
                "Hổ lại hỏi:\n" +
                "\n" +
                "– Sao gan người có cái gì vương vướng khó ăn?\n" +
                "\n" +
                "Vợ hổ nói:\n" +
                "\n" +
                "– Gan người không mềm bằng gan trâu, gan lợn, nhưng gan người bổ hơn gan trâu, gan lợn.\n" +
                "\n" +
                "Hổ ăn xong thì lưỡi hổ tóe máu, toạc ra làm đôi, ruột hổ đau như kim đâm. Vợ hổ cài cửa đá lại thật cẩn thận. Hổ gầm, hổ quát, hổ kêu. Hổ gọi vợ hổ ra đấm lưng cho hổ. Vợ hổ không ra, hổ nói:\n" +
                "\n" +
                "– Mày phản tao, tao biết rồi.\n" +
                "\n" +
                "Nó gầm lên một tiếng, đá trong hang lở ầm ầm. Nó húc vào ngăn bên, đá vỡ toác ra. Nó trông thấy vợ đang ôm hai đứa trẻ. Nó lách vào, nhưng đá đã kẹp lấy đầu con hổ, đầu con hổ vỡ toác ra. Thằng Nhà, con Gạo và vợ hổ phải đưa tay lên bịt mũi vì mùi tanh hôi của con hổ.\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Hổ chết rồi. Phải đem chôn hổ ngoài hang.\n" +
                "\n" +
                "Ba người đào một cái hố sâu, vứt xác hổ xuống, lấp đất lên.\n" +
                "\n" +
                "o O o\n" +
                "Con Gạo đem manh áo rách của người mẹ ra phơi. Nhớ mẹ, Gạo khóc, nước mắt của Gạo rơi xuống đất. Thằng Nhà vừa nhớ mẹ vừa thương em, cũng khóc, nước mắt của Nhà rơi xuống đất. Người con gái vừa nhớ nhà vừa thương hai đứa trẻ bơ vơ, cũng khóc, nước mắt của người con gái rơi xuống đất. Thằng Nhà vào trong ngăn lấy ra một hột muỗm đem vùi xuống đất. Nó nói:\n" +
                "\n" +
                "– Muỗm ơi, mày mọc lên cho chúng tao khuây khỏa chút nào.\n" +
                "\n" +
                "Sáng hôm sau, ba người chạy ra, thấy muỗm đã mọc mầm. Gạo không khóc nữa. Người con gái cũng vui lên. Buổi trưa, ba người chạy ra, thấy muỗm đã cao bằng đầu người con gái. Ba người vỗ tay cười. Buổi chiều, ba người chạy ra, thấy muỗm đã cao vút tới mây, cành lá rườm rà như một cái tán lớn mở ra rợp cả một vùng. Ba người đứng dưới gốc muỗm nhảy nhót. Sáng hôm sau, muỗm chi chít những quả là quả.\n" +
                "\n" +
                "Người con gái trảy ba quả muỗm vừa ngọt vừa thơm. Ba người ăn vào mát lòng mát dạ. Chim rừng nghe tin hổ chết, trước hang hổ lại có cây muỗm to bóng râm rất mát, quả vừa thơm vừa ngọt. Chúng nó ríu rít ca, rủ nhau bay đến cây muỗm.\n" +
                "\n" +
                "Đầu tiên là chim chào mào. Thằng Nhà ngồi dưới gốc muỗm với con Gạo và người con gái, thấy chào mào nghiêng mào ăn muỗm, bèn hỏi:\n" +
                "\n" +
                "– Chào mào có biết mẹ tôi ở đâu không?\n" +
                "\n" +
                "Chào mào hỏi:\n" +
                "\n" +
                "– Người thế nào?\n" +
                "\n" +
                "– Giống tôi như đúc.\n" +
                "\n" +
                "– Thế thì không biết.\n" +
                "\n" +
                "– Chào mào không biết thì không cho chào mào ăn.\n" +
                "\n" +
                "Thằng Nhà xua con chào mào. Chào mào vừa bay đi thì một con sáo đến. Thằng Nhà ngồi dưới gốc cây muỗm với con Gạo và người con gái, thấy sáo đang lấy mỏ ngắt rỉa một quả muỗm, bèn hỏi:\n" +
                "\n" +
                "– Sáo có biết mẹ tôi ở đâu không?\n" +
                "\n" +
                "– Người thế nào?\n" +
                "\n" +
                "– Giống tôi như đúc.\n" +
                "\n" +
                "– Thế thì không biết.\n" +
                "\n" +
                "– Sáo không biết thì không cho sáo ăn.\n" +
                "\n" +
                "Thằng Nhà xua con sáo. Sáo vừa bay đi thì một con đại bàng đến. Đại bàng mào đỏ mỏ vàng, lông cổ óng ánh năm mầu, hai cánh xòe ra rợp cả hang hổ. Thằng Nhà ngồi dưới gốc cây muỗm với con Gạo và người con gái, thấy đại bàng ăn quả, bèn hỏi:\n" +
                "\n" +
                "– Đại bàng có biết mẹ tôi ở đâu không?\n" +
                "\n" +
                "Đại bàng nhìn thằng Nhà, nhìn con Gạo một lúc lâu lại nhìn người con gái.\n" +
                "\n" +
                "Đại bàng nói:\n" +
                "\n" +
                "– Đại bàng có biết một bà giống hai em như đúc, bà có một trai tên là Nhà, một gái tên là Gạo, bà vẫn nhắc hai con, nhưng không biết đường về.\n" +
                "\n" +
                "– Thế thì đúng là mẹ chúng tôi rồi. Mẹ tôi ở đâu, đại bàng?\n" +
                "\n" +
                "– Phải đi qua ba rừng, bốn sông, bảy núi, rồi đến một bến sông, nước trong như gương, bến có một cây đa um tùm mát rượi. Mẹ các em thường hay đến đấy tắm rửa.\n" +
                "\n" +
                "– Đại bàng dẫn chúng tôi đi tìm mẹ nhé.\n" +
                "\n" +
                "– Để đại bàng ăn no thì đại bàng dẫn các em đi tìm mẹ.\n" +
                "\n" +
                "– Thế thì đại bàng ăn đi, ăn nhanh lên rồi đưa chúng tôi đi tìm mẹ.\n" +
                "\n" +
                "Đại bàng ăn xong, nói:\n" +
                "\n" +
                "– Hai em trèo lên mình đại bàng, mình đại bàng êm như bông, ấm như nắng, đại bàng sẽ dẫn hai em đi tìm mẹ.\n" +
                "\n" +
                "o O o\n" +
                "Thằng Nhà đỡ con Gạo lên mình đại bàng, rồi bước lên ngồi đằng sau đứa em. Hai anh em quay lại thấy người con gái đứng trước cửa hang, mặt buồn buồn như mặt người mẹ . Người con gái nói:\n" +
                "\n" +
                "– Hai em đi tìm mẹ, chị thì bao giờ tìm thấy nhà?\n" +
                "\n" +
                "Người con gái sa nước mắt, nước mắt trong như nước suối.\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Đại bàng ơi, đại bàng có giúp cho chị tôi tìm được nhà không?\n" +
                "\n" +
                "Đại bàng nói:\n" +
                "\n" +
                "– Ra bờ suối, đi vào con đường đá, đến tìm ông lão Đá ông lão Đá sẽ chỉ đường cho chị về nhà.\n" +
                "\n" +
                "Người con gái nói:\n" +
                "\n" +
                "– Làm sao mà tìm đến được nhà ông lão Đá?\n" +
                "\n" +
                "– Đại bàng sẽ thả lá muỗm ở dọc đường, chỗ nào có lá muỗm thì đi, chị sẽ tìm được nhà ông lão Đá.\n" +
                "\n" +
                "Người con gái nói với hai đứa bé:\n" +
                "\n" +
                "– Hai em tìm được mẹ rồi thì về chỗ ông lão Đá cho chị được gặp, kẻo chị nhớ hai em.\n" +
                "\n" +
                "Thằng Nhà nói:\n" +
                "\n" +
                "– Dù xa, dù khó chúng em cũng tìm gặp chị.\n" +
                "\n" +
                "Người con gái đứng trước cửa hang, nhìn hai đứa trẻ gật gật đầu. Con Gạo giữ chặt manh áo rách của mẹ. Thằng Nhà một tay giữ Gạo, một tay nắm lông cổ đại bàng. Đại bàng cất tiếng hót như tiếng sáo, xòe hai cánh biếc như mây xanh, bay bổng lên giời. Hai anh em quay lại thấy người con gái vẫn đứng trước cửa hang gật gật đầu. Đại bàng thỉnh thoảng lại nhả xuống một lá muỗm.\n" +
                "\n" +
                "o O o\n" +
                "Đại bàng bay qua rừng, bay qua núi, mình đại bàng êm như bông, ấm như nắng, tiếng đại bàng kêu như tiếng sáo. Đại bàng bay qua một con sông, thằng Nhà giật lông cổ đại bàng, hỏi:\n" +
                "\n" +
                "– Đây rồi phải không, đại bàng?\n" +
                "\n" +
                "Đại bàng nói:\n" +
                "\n" +
                "– Chưa phải. Bến sông mẹ em hay tới trong chứ không đục.\n" +
                "\n" +
                "Thỉnh thoảng con Gạo nói:\n" +
                "\n" +
                "– Đại bàng ơi, đại bàng thả lá muỗm xuống kẻo chị tôi lạc lối.\n" +
                "\n" +
                "Đại bàng bay qua rừng, bay qua núi, mình đại bàng êm như bông, ấm như nắng, tiếng đại bàng kêu như tiếng sáo. Đại bàng bay qua một con sông, có bến um tùm.\n" +
                "\n" +
                "Thằng Nhà giật lông cổ đại bàng, nói:\n" +
                "\n" +
                "– Đây rồi phải không đại bàng?\n" +
                "\n" +
                "Đại bàng nói:\n" +
                "\n" +
                "– Chưa phải. Bến sông mẹ em hay tới là bến cây đa, không phải bến cây si.\n" +
                "\n" +
                "Con Gạo chực khóc. Nó nói:\n" +
                "\n" +
                "– Có gặp mẹ thật không?\n" +
                "\n" +
                "Đại bàng nói:\n" +
                "\n" +
                "– Gạo đừng sốt ruột. Phải bay qua đủ ba rừng, bốn sông, bảy núi mới tìm thấy mẹ.\n" +
                "\n" +
                "Đại bàng bay hết ba rừng, bốn sông, bảy núi, mình đại bàng êm như bông, ấm như nắng, tiếng đại bàng kêu như tiếng sáo. Tới một bến sông, có một cây đa cổ thụ um tùm, đại bàng từ từ đỗ xuống. Lúc ấy vào giữa trưa. Đại bàng nói:\n" +
                "\n" +
                "– Mẹ hai em ở đây.\n" +
                "\n" +
                "Thằng Nhà và con Gạo nhảy xuống đất vỗ tay cười. Thằng Nhà ôm lấy cổ đại bàng nói:\n" +
                "\n" +
                "– Đại bàng tốt lắm. Bây giờ đại bàng chỉ cho tôi đến chỗ mẹ tôi.\n" +
                "\n" +
                "Đại bàng nói:\n" +
                "\n" +
                "– Các em trèo lên cây đa, tới cái cành chĩa ngang mặt nước. Các em nhìn xuống sông. Lát nữa, bà con đi kiếm củi qua đây, thường hay xuống rửa mặt. Các em thấy trên mặt nước, ai giống mặt hai em, thì đấy chính là mẹ các em.\n" +
                "\n" +
                "Nói xong, con đại bàng mào đỏ, mỏ vàng, lông cổ óng ánh năm mầu, mình êm như bông, ấm như nắng, xòe cánh to rộng, vỗ cánh bay cao, tiếng kêu êm ái như tiếng sáo.\n" +
                "\n" +
                "Thằng Nhà đỡ con Gạo trèo lên cây đa. Hai anh em bám trên cái cành cao mọc chĩa ra ngang mặt nước. Chúng nó soi mặt trên dòng sông trong vắt, mặt hai đứa nổi trên mặt nước, giống nhau như đúc.\n" +
                "\n" +
                "Những người đàn bà đi kiếm củi về, buổi trưa oi bức, ai nấy đều đặt gánh củi dưới gốc đa, rồi xuống bến rửa mặt lau mình. Thằng Nhà và con Gạo nhìn xuống mặt sông. Mặt chúng nó hiện lên rất rõ, nhưng hai đứa không thấy mặt ai giống như mặt chúng nó. Đám người rửa mặt lau mình xong, lại cất gánh đi. Đám người khác đến. Thằng Nhà và con Gạo lại nhìn xuống mặt sông nhưng không thấy mặt ai giống như mặt chúng nó. Con Gạo khóc, thằng Nhà nói:\n" +
                "\n" +
                "– Em Gạo đừng khóc, đại bàng không nói dối đâu.\n" +
                "\n" +
                "Đám người rửa mặt lau mình xong, lại cất gánh đi. Đám người khác đến. Thằng Nhà và con Gạo nhìn xuống mặt sông, mặt chúng nó hiện lên rất rõ, giống nhau như đúc. Bỗng chúng nó thấy hiện trên mặt nước trong, mặt một người đàn bà giống mặt chúng nó như đúc. Người đàn bà đang rửa mặt, cũng thấy hiện trên mặt nước trong mặt hai đứa trẻ giống mặt mình như đúc. Nước mắt của người đàn bà rỏ xuống dòng sông. Nước mắt của thằng Nhà, nước mắt của con Gạo cũng rỏ xuống dòng sông. Dòng nước trôi, nước sông trong vắt, ba khuôn mặt giống nhau như đúc, chụm vào nhau rồi lại tỏa ra, tỏa ra rồi lại chụm vào nhau.\n" +
                "\n" +
                "Con Gạo giơ manh áo rách vẫy . Nó nói:\n" +
                "\n" +
                "– Mẹ ơi!\n" +
                "\n" +
                "Thằng Nhà cũng nói:\n" +
                "\n" +
                "– Mẹ ơi!\n" +
                "\n" +
                "Người đàn bà giơ tay ra đón hai đứa trẻ. Mặt người mẹ không buồn nữa, mắt người mẹ không mờ nữa. Tiếng nói êm như ru cất lên:\n" +
                "\n" +
                "– Lại đây con.\n" +
                "\n" +
                "Thằng Nhà và con Gạo ôm chặt lấy người mẹ, người mẹ ôm chặt lấy hai con. Người mẹ nói:\n" +
                "\n" +
                "– Mẹ đi kiếm ăn, mong cho Nhà có nhà, Gạo có gạo, không ngờ lạc đường, để đến nỗi hai con khổ sở.\n" +
                "\n" +
                "Vừa nói vừa vuốt tóc rối bù của con giai, lau nước mắt cho con gái. Tiếng người mẹ êm hơn tiếng sáo của đại bàng, êm hơn tiếng người con gái trong hang hổ. Tay người mẹ êm hơn bông, ấm hơn nắng. Thằng Nhà bắt đầu kể cho mẹ nghe những chuyện chúng nó gặp ở dọc đường. Người mẹ nói:\n" +
                "\n" +
                "– Chúa làng chết rồi, hổ cũng không còn. Mẹ con ta gặp nhau, thế nào Nhà cũng có nhà, Gạo cũng có gạo.\n" +
                "\n" +
                "Người mẹ cất tiếng hát ru cho hai con ngủ, và nói:\n" +
                "\n" +
                "– Các con ngủ đi cho đỡ mệt. Tội tình các con vất vả. Chốc nữa mẹ sẽ mua quà cho các con ăn.\n" +
                "\n" +
                "Trong tay người mẹ, hai anh em đánh một giấc ngủ ngon. Người mẹ nhìn con, khi thì mỉm cười, khi lại ứa nước mắt. Người mẹ hát:\n" +
                "\n" +
                "– Trở về làng từ nay có nhà, có gạo, có mẹ có con. Con ơi con ngủ cho ngoan…\n" +
                "\n" +
                "Nguồn: Truyện cổ tích tổng hợp."));
        list.add(new TruyenCoTich(4,R.drawable.truyen4,"Viên Ngọc Ếch" , "Truyện cổ tích thần kỳ Viên ngọc ếch kể rằng, ngày xưa có anh chàng sinh ra trong một nhà giàu, nên rất được cha mẹ nuông chiều, anh suốt ngày chỉ mải ăn chơi không phải làm gì. Đến khi cha mẹ già lâm bệnh qua đời, anh bán tất cả của cải cha mẹ để lại và tiêu xài hết. Đến lúc không còn gì để ăn nữa, anh đành ngửa tay xin mọi người bố thí. Có cụ già trong làng đưa anh về cho ở nhờ và dạy cho anh nghề đào ít kiếm sống.\n" +
                "\n" +
                "Ít lâu sau, cụ còn cưới vợ cho anh. Từ đó anh chàng thay tâm đổi tính, chịu khó làm ăn. Ngày nào anh cũng dậy sớm, vác thuổng đi đào ếch. Chẳng bao lâu anh đã nổi tiếng là người đào ếch giỏi nhất vùng. Vợ anh lại là người đảm đang tháo vát nên cuộc sống của họ ngày càng khấm khá. Một hôm anh đi đào từ sáng sớm đến chiều mà vẫn không bắt được một con ếch nào.\n" +
                "\n" +
                "Anh chán nản định bỏ về thì chợt thấy một cái hàng to, cửa hang còn hằn rõ những vết chân ếch. Anh vừa sơ thuổng lên đào được mấy nhát thì một con ếch cụ nhảy ra. Anh đào ích giật mình kinh ngạc thấy ít chắp tay và van lạy bằng tiếng người:\n" +
                "\n" +
                "- Xin ông tha cho tôi! Tôi già rồi chẳng sống được bao lâu nữa! Ếch vừa nói vừa rưng rưng nước mắt khiến người đọc cảm động. Anh cúi xuống bảo:- Ngươi đã nói vậy thì ta cũng không nỡ bắt!\n" +
                "\n" +
                "Rồi anh sửa sang lại cái hang mình vừa bới và bảo ếch vào nghỉ. Trở về nhà, anh kể cho vợ nghe. Vợ anh xuýt xoa:\n" +
                "\n" +
                "- Ếch to như thế thì béo và ngon lắm.Mai mình cứ bắt nó về để em làm thịt cho mà nhắm rượu!\n" +
                "\n" +
                "Sáng hôm sau, nghĩ thương con ếch cụ nên anh đào ếch cứ nấn ná mãi. Sau bị vợ giục quá, anh đành đến gặp ếch. Ếch lại chắp tay lạy anh:\n" +
                "\n" +
                "- Trăm lạy ông, xin ông tha cho tôi!\n" +
                "\n" +
                "- Ta cũng muốn tha cho ngươi, nhưng vợ ta cứ muốn bắt ngươi về làm thịt.\n" +
                "\n" +
                "- Làm thịt là thế nào hở ông?\n" +
                "\n" +
                "Anh đào ếch ngần ngừ một lúc rồi nói:\n" +
                "\n" +
                "- Làm thịt là chặt đầu, chặt chân, lột da, băm viên, rồi thêm mẻ, thêm ớt, thêm mắm thêm muối và bỏ vào nồi nấu.\n" +
                "\n Ếch nghe vậy vừa khóc vừa nói:\n" +
                "\n" +
                "- Tôi đã già quá rồi. Thôi, đằng nào cũng phải chết, nhưng xin ông đừng bắt tôi làm thịt. Tôi sẽ biếu ông viên ngọc cải tử hoàn sinh.\n" +
                "\n" +
                "Ếch nói xong, nhả viên ngọc ếch trong miệng ra rồi gục xuống chết ngay. Anh đào ếch đào đất đắp mộ cho nó rồi nhặt ngọc cất cẩn thận vào túi. Trên đường về, thấy một con rắn bị đánh nằm chết bên vệ đường. Anh mài ngọc rồi nhỏ cho rắn một giọt. Chỉ trong tích tắc, con rắn ngọ nguậy sống lại. Rắn gật đầu như tỏ ý cảm ơn rồi bò đi mất hút. Anh ấy còn thử ngọc ếch với một con chuột và một con ong. Cả hai con vật đã chết đều sống lại.\n" +
                "\n" +
                "Từ đó, anh dùng ngọc để chữa bệnh và cứu giúp mọi người. Bất kể sáng sớm hay đêm hôm khuya khoắt, hễ có ai cần, anh đào ếch đều đem ngọc đến cứu ngay. Bà con trong vùng đều yêu quý, gọi anh là Ân Nhân, lâu dần thành tên. Lúc bấy giờ, nước ta bị giặc ngoại xâm xâm lược. Thế địch rất mạnh, quân lính triều đình đã mấy lần phải rút lui. Đức vua cho sứ giả đi khắp nơi kêu gọi, tìm người hiền tài cứu nước. Anh đào ếch nghe tiếng loa, đứng ngồi không yên. Bỗng mấy con vật được anh cứu sống hôm nào kéo đến nhà. Cả ba con cung nói:\n" +
                "\n" +
                "- Ân nhân cứ xin với nhà vua đi dẹp giặc. Chúng tôi sẽ giúp ngài lập nên công trạng.\n" +
                "\n" +
                "Nghe lời rắn, chuột và ong, anh đào ếch vội theo sứ giả lên kinh đô tâu với nhà vua cho đi đánh giặc. Anh chỉ xin vua ban cho một trăm chum mật, một trăm bồ nhái và một trăm cót thóc. Vua lấy làm lạ, nhưng vẫn sai truyền cấp đủ mọi thứ và còn ban thêm một con ngựa, một thanh bảo kiếm cho anh. Khi tiễn anh đào ếch ra trận, vua quan cùng dân chúng sửng sốt khi thấy hàng đàn rắn, chuột và ong ào ào theo anh đi đánh giặc. Anh đào ếch sai chuột đi đào khoét xung quanh trại giặc rồi ra lệnh cho rắn và ong tấn công.\n" +
                "\n" +
                "Dưới đất lúc nhúc đầy rắn, trên trời ong bay dày đặc. Rắn và ong cứ nhằm quân giặc mà cắn, mà đốt còn chuột cứ nhằm tai mũi giặc mà khoét. Quân giặc tối tăm mặt mũi không biết đường nào mà chống đỡ. Chẳng mấy chốc, quân giặc bị trúng độc vì nọc rắn, nọc ong lăn ra chết như rạ.\n" +
                "\n" +
                "Cuối cùng, không chống đỡ nổi những con vật lợi hại, tướng giặc phải đầu hàng. Anh đào ếch phấn khởi đem mật, thóc lúa và nhái bén ra đãi các con vật, cảm ơn chúng đã giúp mình đánh tan quân giặc. Rồi anh phóng ngựa về kinh đô báo tin thắng trận. Đức vua vui mừng truyền ban quan tước và thưởng bổng lộc rất hậu hĩnh cho chàng đào ếch dũng cảm."));
    }
}