
import pandas as pd

from apyori import apriori


# from mlxtend.frequent_patterns import apriori, association_rules
class Customer:
    def __init__(self, customerId, country, siparisList):
        self.customerId = customerId
        self.country = country
        self.siparisList = siparisList

    def __repr__(self):
        return self.customerId

    def __eq__(self, other):
        return self.customerId == other


class Order:
    def __init__(self, invoiceNo, productsList, invoiceDate):
        self.invoiceNo = invoiceNo
        self.productsList = productsList
        self.invoiceDate = invoiceDate

    def __str__(self):
        return "Products" + self.productsList

    def __repr__(self):
        return "Products" + self.productsList

    def __eq__(self, other):
        return self.invoiceNo == other


adata = pd.read_excel('Online Retail.xlsx')
adata.head()
adata = adata.dropna()
customers = []
products = []
customers2 = []
for row in adata.values:
    custID = row[6]
    customer: Customer = None
    if custID not in customers:
        customer = Customer(custID, row[7], [])
        customers.append(customer)
    else:
        i = customers.index(custID)
        customer = customers[i]

    invoiceNo = row[0]
    product = row[2]
    if invoiceNo not in customer.siparisList:
        order = Order(invoiceNo, [], row[4])
        order.productsList.append(product)
        customer.siparisList.append(order)
    else:
        i = customer.siparisList.index(invoiceNo)
        customer.siparisList[i].productsList.append(product)
# for i in range(0,len(customers)):
# customer = customers[i]
#  print(customer.customerId)
#  print(len(customer.siparisList))
#  for order in customer.siparisList:
#      print(order.invoiceNo)
#     for product in order.productsList:
#         print(product)

#  print("=======================")

# customer=customers[1]
# print(customer.customerId)
# for order in customer.siparisList:
#   products.append(order.productsList)

'''for i in range(0, len(customers)):
    customer = customers[i]

    if len(customer.siparisList) > 1:
        # print(customer.customerId)
        customers2.append(customer) '''

# print(len(customers))
# print(len(customers2))

for i in range(0, len(customers)):
    customer = customers[i]
    for order in customer.siparisList:
        products.append(order.productsList)

birliktelik_kural = apriori(products, min_support=0.01, min_confidence=0.5, min_lift=3, min_length=2)
birliktelik_sonuc = list(birliktelik_kural)

print("toplam kural sayısı : ", len(birliktelik_sonuc))

for x in birliktelik_sonuc:

    kural = x[0]
    items = [x for x in kural]
    print("Kural: " + items[0] + " -> " + items[1])

            # second index of the inner list
    print("Destek: " + str(x[1]))

            # third index of the list located at 0th
            # of the third index of the inner list
    print("Güven: " + str(x[2][0][2]))
    print("Lift: " + str(x[2][0][3]))
    print("=====================================")

print(len(customers))
print(len(products))

