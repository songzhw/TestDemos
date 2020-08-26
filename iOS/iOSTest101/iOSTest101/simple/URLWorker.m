#import "URLWorker.h"

@implementation URLWorker
- (NSDictionary *)getParams:(NSString *)src {
  NSRange focus = [src rangeOfString:@"?"]; //相当于java中的 str.indexOf("?") //NSRange {location, length}
  NSString* argsString = [src substringFromIndex:(focus.location+1)];
  NSMutableDictionary* dict = @{}.mutableCopy;
  NSArray* args = [argsString componentsSeparatedByString:@"&"]; //相当于java的str.split("&"), 每一项结果都不包含"&". "x=1&b=2"会分解为"x=1"与"b=2"
  [args enumerateObjectsUsingBlock:^(NSString* obj, NSUInteger idx, BOOL *  stop) {
    NSArray* keyValue = [obj componentsSeparatedByString:@"="];
    NSString* key = keyValue[0];
    NSString* value = keyValue[1];
    dict[key] = value;
  }]; //相当于java中的 ary.forEach {}
  return dict;
}
@end
