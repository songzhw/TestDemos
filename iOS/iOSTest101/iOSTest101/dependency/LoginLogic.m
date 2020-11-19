#import "LoginLogic.h"
#import "HttpEngine.h"

@implementation LoginLogic
- (NSString*)loginWithName:(NSString *)name pwd:(NSString *)pwd{
//  NSString* url = [NSString stringWithFormat:@"https://myhost.com/login?name=%@&pwd=%@", name, pwd];
  HttpEngine* http = [HttpEngine new];
  NSString* url = @"https://run.mocky.io/v3/274b7ea7-9581-49c1-b350-00662ee02386";
  NSString* resp = [http requestWithUrl:url];
  return resp;
}
@end
