import dns.resolver
import dns.rdatatype

import dns
import argparse


parser = argparse.ArgumentParser(
    prog='A simple dns client'
)
parser.add_argument("domain")
parser.add_argument("-t", "--type")

args = parser.parse_args()

if args.type not in ["A", "AAAA", "CNAME", "NS", "MX"]:
    print("Unsupported Type:" + args.type)
    exit()
    
domain = args.domain
type  = 0
if args.type == "A":
    type = dns.rdatatype.A
elif args.type == "AAAA":
    type = dns.rdatatype.AAAA
elif args.type == "CNAME":
    type = dns.rdatatype.CNAME
elif args.type == "NS":
    type = dns.rdatatype.NS
elif args.type == "MX":
    type = dns.rdatatype.MX
    
queryResult = dns.resolver.resolve(domain, type)
print("Querying Response:")
print(queryResult.response)