#import "URLWorker.h"

@implementation URLWorker
- (NSDictionary *)getParams:(NSString *)src {
  NSRange focus = [src rangeOfString:@"?"]; //相当于java中的 str.indexOf("?") //NSRange {location, length}
  
  // NSLog(@"range = %@", NSStringFromRange(focus)); //=> 没有找到就会返回 range = {9223372036854775807, 0}
  if(focus.location == NSNotFound){  //源码: static const NSInteger NSNotFound = NSIntegerMax;
    return nil;
  }
  
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
