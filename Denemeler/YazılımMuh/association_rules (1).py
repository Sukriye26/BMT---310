# -*- coding: utf-8 -*-
"""
Created on Sun Feb 23 09:17:33 2020

@author: Sukriye
"""

#kütüphanelerin eklenmesi
#import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from mlxtend.frequent_patterns import apriori, association_rules 
import seaborn as sns
#sns.set()
from itertools import combinations, groupby
from collections import Counter

"""
burda öncelikle ülkelere göre ayırmam gerekli
birde veri temizliği yapmam lazım.
"""
adata=pd.read_excel('Online_Retail.xlsx')
adata.head()
"""
#plt.figure(figsize=(18,12))
#plt.plot(adata.InvoiceDate,adata.Country,color="red")
#
#plt.title("Tarihlere göre ülkelerdeki satışlar")
#plt.xlabel("Tarih")
#plt.ylabel("Ülke")
#plt.show()
                     #grafik çizmek için ama işlemciyi çok yoruyor"""
print("sütunlar ve veri tipleri")
adata=adata.dropna()
print(adata.columns)
print("===========================================")
print("Çerçeve hakkında genel bilgi")
print(adata.info())
print("===========================================")
print("Her sütunda bulunan boş değerler toplamı")
print(adata.isnull().sum().sort_values(ascending=False))
print("===========================================")
print(adata["Country"].describe())
print("=============================")
"""
count =boş olmayan girdi sayısı
unique : birbirinden farklı kaç kategori olduğunun bilgisi.
top : sütunda en çok bulunan kategorinin adı.
freq : en çok bulunan kategorinin sütunda bulunma sıklığı.
"""

df=adata["Description"].value_counts()
print(df)
df.to_frame(name='column_name').to_excel('xlfile.xlsx', sheet_name='s')

#df.to_excel(r'C:\Users\cvdrs\anaconda3\Veri Bilimi\sayilar.xlsx' ,index=False , header = True)

#print(adata.sum().sort_values(ascending=False))

print("===========================================")
#print(adata.describe(include=['O']))
#print("===========================================")
#print("her bir değerin sütunda bulunma sayısı")
##Nan olmayana girdilerin kaç defa bulunduğunu gösterir.
#yeni =adata["Description"].value_counts()
#yeni.head()
##print(adata["Description"].value_counts())
#print("===========================================")
#print("veri setinde bulunan farklı ülkeler")
#ulkeler=adata.Country.unique()
#print(ulkeler)
#print("toplam ülke sayısı =" ,len(ulkeler) )
#print("===========================================")
""" 
burada ülkelerin içindeki benzersiz kayıtları aldım.
ülkeleri buldum 
"""

#data.dropna(axis = 0, subset =['CustomerID'], inplace = True) 
""" dropna() NaN değerler bulunduran satırları silmeyi sağlar."""
#print("dropna sonrası")
#
#adata=adata.dropna()
#print(adata.isnull().sum().sort_values(ascending=False))
#print("çerceve bilgisi")
#print(adata.info())
#print("==========================================")
#
#cancelled_orders =adata[adata['InvoiceNo'].astype(str).str.contains('C')]
#cancelled_orders.head()
#print("iptal edilen " , len(cancelled_orders) ," sipariş vardır.")
#""" burda da görüldüğü üzere eksik veri kalmadı """
#print("==========================================")
#print()
#total_orders = adata['InvoiceNo'].nunique()
#cancelled_number = len(cancelled_orders)
#print("İptal edilen siparişlerin yüzdesi: {}/{} ({:.2f}%) ".format(cancelled_number, total_orders, cancelled_number/total_orders*100))
##{}/{} ({:.2f}%) yazdırma formatını belirliyoruz.
##İptal edilen siparişlerin yüzdesi %40'tır. 
##İptal edilen bu siparişlerin incelenmesi ileride iptal etmenin önlenmesine yardımcı olabilir.
#print("==========================================")
##sns.pairplot(adata,hue='Country')
#
#print("hadi biraz veri setini kurcalayalım :))")
#print("=======================================")
## fazla boşlukları siliyoruz 
#adata['Description'] = adata['Description'].str.strip() 
##  
### invoince numarası hala yoksa o satırları çıkarıyorum 
#adata.dropna(axis = 0, subset =['InvoiceNo'], inplace = True) 
#adata['InvoiceNo'] = adata['InvoiceNo'].astype('str') 
##  
### invoince numarasında c olanları (canceled) alişverişleri çıkarıyoruz
#adata = adata[~adata['InvoiceNo'].str.contains('C')] 
#adata
##♥ aşağıdaki satırı çalıştırarak negatif miktarda satın alınan tüm hatları da kaldıralım.
#adata= adata[ ~adata [ 'Quantity' ] <  0 ]
#print("İşlem Sayısı: ", adata['InvoiceNo'].nunique())
## dataframe.nunique()işlev dönüşü İstenen eksen üzerinde farklı gözlem sayısına sahip serileri gösterir
##
##
#print("Satın alınan ürün sayısı: ",adata['StockCode'].nunique())
#
#
#print("müşteri sayısı: ", adata['CustomerID'].nunique() )
#print("fatura",adata['InvoiceNo'].nunique())
#print('ülke sayısı: [2.yol] --> ',adata['Country'].nunique())
#print("describe") #describe?
#print(adata.describe())
#
#print("===========================================")
#adata['total_cost'] = adata['Quantity'] * adata['UnitPrice']
#adata.head()
#
##fig, ax = plt.subplots()
##fig.set_size_inches(13, 11.5)
##ax=sns.barplot(x='Country', y='total_cost',data=adata,estimator=max,ax=ax)
##ax.set_xticklabels(ax.get_xticklabels(), rotation=47, ha="right")
##plt.xlabel("Ülke")
##plt.ylabel("Toplam Tutar")
##plt.show()
##print("===========================================")
##adata.groupby('Country').sum().sort_values(by='total_cost', ascending=False)
##""" ülkelere göre toplam satış tutarları için grafik """
##
##print("===========================================")
#
#print("grafigi atladım")
#print("========================")
#
#basket_France = (adata[adata['Country'] =="France"] # adatanın içinde ülke sütunu fransa olan kayıtları 
#          .groupby(['InvoiceNo', 'Description'])['Quantity'] 
#          .sum().unstack().reset_index().fillna(0) #reset_index index numaralarını almadan data frame oluştur
#          .set_index('InvoiceNo')) #set_index de indexi InvoinceNo yap
#basket_France
#
#basket_Uk = (adata[adata['Country'] =="United Kingdom"] #ülkesi UK olan kayıtları
#          .groupby(['InvoiceNo', 'Description'])['Quantity'] 
#          .sum().unstack().reset_index().fillna(0) 
#          .set_index('InvoiceNo')) 
#basket_Uk
#""" Bu, sepet başına satın alınan her bir ürünün sayısını analiz etmek için yararlıdır, ancak sepet ilişkisinin kendisini analiz etmek için çok fazla değildir. 
#Bu nedenle, hacmi çıkarmak ve sadece belirli bir ürünün herhangi bir miktarının o sepetin bir parçası olarak satın alınıp alınmadığını söylemek için  
# veri çerçevesini, yalnızca satın alma işleminin gerçekleştiğini gösteren dönüştürme işlemi (one-hot-encoding) 
#"""
#basket_Germany = (adata[adata['Country'] =="Germany"] #ülkesi Germany olan kayıtları
#          .groupby(['InvoiceNo', 'Description'])['Quantity'] 
#          .sum().unstack().reset_index().fillna(0) 
#          .set_index('InvoiceNo')) 
#basket_Germany
#
#def encode_units(x): #burada da aynı üründen bir tane de  birden fazla da alınmış olsa bizim için aynı değeri ifade ediyor
#    if x <= 0:       #buna göre kodlama yapıyoruz.
#        return 0     #sıfırdan küçükse hepsini 0 yap
#    if x >= 1:       #birden büyükse de bir yap
#        return 1
#    """ayrıca da """
#    #Verilerde çok sayıda sıfır var, ancak pozitif değerlerin 1'e dönüştürüldüğünden ve 0'dan küçük herhangi 
#    #bir şeyin 0'a ayarlandığından emin olmamız gerekiyor
#
#print("UK")
#basket_setu = basket_Uk.applymap(encode_units)
#basket_setu.drop('POSTAGE', inplace=True, axis=1)
#basket_setu
#frequent_itemsetsu = apriori(basket_setu, min_support=0.03, use_colnames=True)
#rulesu = association_rules(frequent_itemsetsu, metric="lift", min_threshold=1)
#""" min_threshold =1, yalnızca% 100 güvenilir kurallar """
#print(rulesu.head())
#print("============================================")
##print("veri seti çok fazla sütun içerdiği için ekranda net göstermiyor.Variable explorer dan data frame e bakmak gerek kuralları tam anlamıyla incelemek için")
#        
#print("Fransa")
#basket_setf = basket_France.applymap(encode_units) #verisetindeki kayıtları 0 ve 1 e dönüştürüyoruz
#basket_setf.drop('POSTAGE', inplace=True, axis=1)
##postage ?
#basket_setf 
#""" dönüştürdüğümüz kayıtlara da aprirori uyguluyoruz """
#frequent_itemsetsf = apriori(basket_setf, min_support=0.07, use_colnames=True)
#"""
#İlişkilendirme Kuralı Madenciliği yapılırken analiz edilmesi gereken iki önemli metrik vardır. Birincisi, bir kuralın ne sıklıkta doğru olduğunu belirleyen güvendir . Örneğin, insanların süt satın aldığı 7/10 işlemin de ekmek satın aldığı sık bir ürün grubumuz olduğunu varsayalım. Bu, 0,7'lik bir güven metriğine yol açacaktır. Değer ne kadar yüksek olursa kuralın doğru tutması daha olasıdır.
#
#İkincisi asansördür . Artış bağımsızlığın bir ölçüsüdür, yani kuralın ne kadar alakalı olduğu. Diğer ürünlerden bağımsız olarak sık sık satın alınan bazı ürünler olabileceğinden bu önemlidir. Bu durumda, kaldırma metriği düşük olan kurallar, ürünler arasındaki ilişkinin bağımlı olmadığı kadar alakalı değildir. Artış, doğru tutan kural için destek, önceki için destek ürününe ve sonuç için desteğe bölünür. Birden büyük bir kaldırma ölçüsü, iki bileşenin (önceki ve sonuç) birbirine bağımlı olduğu anlamına gelir. Birden az bir rakam, öğelerin birbirinin yerine geçtiği anlamına gelir.
#
#Mlxtend paketi ile ilgili iyi olan şey , tüm bu metriklerin birkaç hızlı işlev çağrısı ile hesaplanabilmesidir.
#"""
#rulesf = association_rules(frequent_itemsetsf, metric="lift", min_threshold=1)
#print(rulesf.head())
#print("=========================================")
##bir sınırlama yapıyorum
##rulesf[ (rulesf['lift'] >= 6) & (rulesf['confidence'] >=0.8 )]
##ve sonrasında 
##print("rastgele bir ürün için satış sayısı")
##print(basket_setf['ALARM CLOCK BAKELIKE GREEN'].sum())
##print("rastgele farklı bir ürün için satış sayısı")
##print(basket_setf['ALARM CLOCK BAKELIKE RED'].sum())
#print("================================================")
#
#print("Almanya")
#basket_setg=basket_Germany.applymap(encode_units)
#basket_setg.drop("POSTAGE",inplace=True,axis=1)
#basket_setg
#frequent_itemsetsg=apriori(basket_setf, min_support=0.05, use_colnames=True)
#rulesg = association_rules(frequent_itemsetsg, metric="lift", min_threshold=1)
#print(rulesg.head())
#print("=======================================")
##yine rastgele bir sınırlama 
#rulesg[ (rulesg['lift'] >= 4) & (rulesg['confidence'] >=0.5 )]
#
##şimdi sadece orders ları almaya çalışıyorum.
#
#df_manual= adata[adata['Country'] =="United Kingdom"]
#orders = df_manual.set_index('InvoiceNo')['StockCode']
#""" ınvoinceno içinde ürünün stockcode u var mı ona bakacağım için bu iki sütunu aldım. """
#
##aprirori için lazım olan sıklık değeri ile güven değerini elimle hesaplıyorum.
#statistics = orders.value_counts().to_frame("frequency")
#statistics['support']  = statistics / len(set(orders.index)) * 100 
#
#""" burdaki değerden daha küçük destek değeri olanları çıkartıyorum. """
##min_support =0.03 #
##items_above_support = statistics[statistics['support'] >= min_support].index
##orders_above_support = orders[orders.isin(items_above_support)]
##
#""" şimdi de asıl kısma geliyoruz. 1 tane ürün olan siparişleri çıkartıyorum. """
#order_counts = orders.index.value_counts()
#orders2 = order_counts[order_counts>=2].index
#orderss= orders[orders.index.isin(orders2)]
#
#""" data frame güncellendiği için istatistikleri yeniden hesapla """
#statistics = orderss.value_counts().to_frame("frequency")
#statistics['support']  = statistics / len(set(orderss.index)) * 100
#
#
#def itemset_generator(orders):
#    orders = orders.reset_index().values
#    for order_id, order_object in groupby(orders, lambda x: x[0]):
#        item_list = [item[1] for item in order_object]
#        for item_pair in combinations(item_list, 2):
#            yield item_pair
#
#itemsets_gen = itemset_generator(orderss)
#itemsets  = pd.Series(Counter(itemsets_gen)).to_frame("frequencyAC")
#itemsets['supportAC'] = itemsets['frequencyAC'] / len(orderss) * 100
#itemsets = itemsets[itemsets['supportAC'] >= 0.03]
#
#itemsetsy=itemsets
## Create table of association rules and compute relevant metrics
#itemsets = itemsets.reset_index().rename(columns={'level_0': 'antecedents', 'level_1': 'consequents'})
#itemsetsx=itemsets
#
#itemsets = (itemsets.merge(statistics.rename(columns={'freq': 'freqA', 'support': 'antecedent support'}), left_on='antecedents', right_index=True).merge(statistics.rename(columns={'freq': 'freqC', 'support': 'consequents support'}), left_on='consequents', right_index=True))
#itemsx=itemsets
#
#itemsets['confidenceAtoC'] = itemsets['supportAC'] / itemsets['antecedent support']
#itemsets['confidenceCtoA'] = itemsets['supportAC'] / itemsets['consequents support']
#itemsets['lift'] = itemsets['supportAC'] / (itemsets['antecedent support'] * itemsets['consequents support'])
#
#itemsets=itemsets[['antecedents', 'consequents','antecedent support', 'consequents support', 'confidenceAtoC','lift']]
#
#print("================================")
#print("deneme")
#print(itemsets)
##itemsets.to_csv(r'C:\Users\cvdrs\anaconda3\Veri Bilimi\association_rules.csv', index=False , header = True)
#
#
##rules_final = itemsets
##rules_over_50 = rules_final[(rules_final.confidenceAtoC >0.005)]
##rules_over_50.set_index('antecedents',inplace=True)
##rules_over_50.reset_index(inplace=True)
##rules_over_50=rules_over_50.sort_values('lift', ascending=False)
##print(rules_over_50.head())
#
## her yeni kullanıcı tarafından satın alınan herhangi bir ürün, yeni kayıt olan bir kullanıcıya önerilebilir.
##(User-User Collaborative Filtering): Benzer müşteriler ilişkilendirilmeye çalışılır ve müşterilerin seçtiği ürünlere dayanarak ürünler sunulur.
##(Item-Item Collaborative Filtering): Önceki algoritmaya çok benzerdir fakat müşteriler arasında benzerlik bulmak yerine ürün benzerliğine odaklanır. Bu algoritma ile birlikte herhangi bir öğeyi satın alan müşteriye, benzer öğeleri kolaylıkla önerebiliriz.
