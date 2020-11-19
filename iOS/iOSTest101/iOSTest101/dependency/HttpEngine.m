#import "HttpEngine.h"

@implementation HttpEngine
- (NSString*)requestWithUrl:(NSString *)url{
  NSURL* urlObj = [NSURL URLWithString:url];
  NSData* data = [NSData dataWithContentsOfURL:urlObj];
  NSString* str = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
  return str;
}
@end
