#import "ViewController.h"
#import "HttpEngine.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
  [super viewDidLoad];
  HttpEngine* http = [HttpEngine new];
  NSString* resp = [http requestWithUrl:@"https://run.mocky.io/v3/274b7ea7-9581-49c1-b350-00662ee02386"];
  NSLog(@"resp = %@", resp);
}


@end
